/* Aproach: make use of techniques of merge k sorted array
* the idea is to keep a min(pop from pq)-max window out of the first elements from each list,
* this help to ensure the range is cover numbers from all the list. we just need to monitor
* the smallest window */
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>(new Comparator<ArrayContainer>() {
            @Override
            public int compare(ArrayContainer ac1, ArrayContainer ac2) {
                return ac1.val - ac2.val;
            }
        });
        int max = Integer.MIN_VALUE;
        // don't add all the number at once, only add the first number of each list first
        for (int i = 0; i < nums.size(); i++) {
            ArrayContainer ac = new ArrayContainer(nums.get(i).get(0), 0, i);
            pq.offer(ac);
            max = Math.max(max, nums.get(i).get(0));

        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {  // this condition make sure that the range includes element form each list
            ArrayContainer ac = pq.poll();
            if (max - ac.val < range) {
                range = max - ac.val;
                start = ac.val;
                end = max;
            }
            if (ac.index + 1 < nums.get(ac.row).size()) {
                ac.index = ac.index + 1;    // dont need to initialize new ArrayContainer object, make use by chaning the value
                ac.val = nums.get(ac.row).get(ac.index);
                pq.offer(ac);
                if (nums.get(ac.row).get(ac.index) > max) {
                    max = nums.get(ac.row).get(ac.index);
                }
            }
        }
        return new int[] {start, end};
    }

    class ArrayContainer {
        int val;
        int index;
        int row;
        public ArrayContainer(int val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }
}
