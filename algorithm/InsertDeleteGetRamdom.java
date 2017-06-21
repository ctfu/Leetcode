/* require to implement a RandomizeSet with inset, delete and getRandom in o(1) time */
/* using HashMap together with List */
public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> hm;
    Random random;  // getRandom needs to o(1), so need to get random instance */
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        hm.put(val, nums.size()); /* put the val to its according position in list */
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int loc = hm.get(val);
            /* it the num index is not the need, which could take o(n) time, swap it with last element */
            if(loc < nums.size()-1){
                int lastVal = nums.get(nums.size()-1);
                nums.set(loc, lastVal); /* set the lastValue to current index */
                hm.put(lastVal, loc); /* adjust the hm location for lastValue */
            }
            nums.remove(nums.size()-1);
            hm.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size())); /* generate a random index from the list size */
    }
}
