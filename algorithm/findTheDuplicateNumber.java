/* Requirement:
 * 1)number domain is [1, n],
 * 2) n + 1 integers
 * 3) only one duplicate, could repeate multiple times
 * 4) algorithm doesnot modify array elements */

 /* Approach 1: use hashing to hash each element to n-1 position, but modifies array element */
public class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                return index + 1;
            }else{
                nums[index] = -nums[index]; /* here modifies the array element */
            }
        }
        return 0;
    }
}

/* approach that doesn't modify the array */
/* concept: Solve it using technique of LinkedList cycle II
 * 1) Treate the array as abstract LinkedList
 * 2) Array element as index pointing to each other, fast = nums[nums[fast]]
 * 3) Starting from index 0, if there is duplicate, there will be cycle */
public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length > 1){/* array size must be greater than 1 if duplicate happens */
            int slow = nums[0]; /* slow one step */
            int fast = nums[nums[0]]; /* fast two step */

            /* when fast == slow, they meets */
            while(fast != slow){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;   /* fast assign to 0, not nums[0] */
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
}
