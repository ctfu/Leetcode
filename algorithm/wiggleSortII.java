/* virtual index mapping + findKthLargestNumber + sortColor */
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        int median = findKthLargestNumber(nums, (n+1)/2);   /* find the median */
        int begin = 0, end = n-1, i = 0;
        while(i <= end){        /* sort color technique */
            if(nums[mapIndex(i, n)] > median){
                swap(nums, mapIndex(begin++, n), mapIndex(i++, n));
            }else if(nums[mapIndex(i, n)] < median){
                swap(nums, mapIndex(end--, n), mapIndex(i, n));
            }else{
                i++;
            }
        }
    }
    private int mapIndex(int index, int n){ /* virtual index mapping */
        return (2 * index + 1) % (n | 1);   /* (n|1) makes it an odd number */
    }
    private int findKthLargestNumber(int[] nums, int k){
        return findKth(nums, nums.length-k+1, 0, nums.length -1);
    }
    private int findKth(int[] nums, int k, int start, int end){
        int privot = nums[end];
        int left = start, right = end;
        while(left < right){
            while(left < right && nums[left] < privot) left++;
            while(left < right && nums[right] >= privot) right--;
            if(left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, left, end);
        if(left + 1 == k){
            return privot;
        }else if(left + 1 > k){
            return findKth(nums, k, start, left-1);
        }else{
            return findKth(nums, k, left+1, end);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
