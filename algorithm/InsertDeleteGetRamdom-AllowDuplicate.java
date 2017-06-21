public class RandomizedCollection {
    List<Integer> nums;
    Map<Integer, LinkedList<Integer>> hm; /* use a linkedList to store the same key duplcate value */
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        hm = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            hm.get(val).add(nums.size()); /* import to add nums.size() */
            nums.add(val);
            return false;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums.size());
        hm.put(val, list);
        nums.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int loc = hm.get(val).removeFirst();
            if(loc < nums.size()-1){ /* important to test this step */
                int lastValue = nums.get(nums.size()-1);
                nums.set(loc, lastValue);
                hm.get(lastValue).removeLast();/* lastValue will always be the last index of the position LinkedList */
                hm.get(lastValue).addFirst(loc);
            }
            nums.remove(nums.size()-1); /* arrayList remove last element is o(1) */
            if(hm.get(val).size() == 0){ /* if position list is empty */
                hm.remove(val);
            }
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));/* to return getRandom in 0(1) time */
    }
}
