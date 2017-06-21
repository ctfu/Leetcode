/* To obtain the median value:
 * 1. Need to sort the elements in k windows
 * 2. Need to be able to get the median value based on odd or even k size*/
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new double[0];
        }
        double[] res = new double[nums.length-k+1];
        /* use ArrayList not PriorityQueue because get(inex), constant time, but need to sort */
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
            if(list.size() == k){
                Collections.sort(list);
                double val;
                if(k % 2 == 0){ /* get even k window median average of two value */
                    val = (((double)list.get(k/2) + list.get(k/2-1))/2);
                }else{ /* get odd k window median one value */
                    val = (double)list.get(k/2);
                }
                res[index++] = val;
                /* it is important to castinto Integer, otherwise will treat as remove(index)
                 * ranther than remove other value */
                list.remove((Integer)nums[i-(k-1)]);
            }
        }
        return res;
    }
}
