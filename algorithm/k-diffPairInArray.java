/* Find all the pairs in an array with absolute Difference as k , variation of two sum*/
/* Method 1: two pointers (nlog(n)) instead pointer both end, begin = 0, end = 1*/
public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        int begin = 0, end = 1; /* worse case O(2n) */
        while(end < nums.length){
            if(nums[end]-nums[begin] < k || begin == end){  /* if diff < k or begin == end, move end */
                end++;
            }else if(nums[end]-nums[begin] == k){   /* if diff == k */
                if(begin == 0 || begin > 0 && nums[begin] != nums[begin-1]){ /* if not duplicate */
                    res++;
                }
                begin++;
            }else{  /* if diff > k, move begin to decrease gap */
                begin++;
            }
        }
        return res;
    }
}

/* Method 2: HashMap O(n), space O(n)*/
public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;/* absolute difference, so k > 0 */
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(k == 0){
                if(entry.getValue() >= 2){
                    res++;
                }
            }else{
                if(hm.containsKey(entry.getKey()+k)){
                    res++;
                }
            }
        }
        return res;
    }
}
