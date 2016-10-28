public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int index1 = 0, index2 = 0, index3 = 0;
        while(m >0 && n > 0){
            if(nums1[index1] > nums2[index2]){
                temp[index3++] = nums2[index2++];
                n--;
            }else{
                temp[index3++] = nums1[index1++];
                m--;
            }
        }
        while(m > 0){
            temp[index3++] = nums1[index1++];
            m--;
        }
        while(n > 0){
            temp[index3++] = nums2[index2++];
            n--;
        }
        index1 = 0;
        for(int num : temp){
            nums1[index1++] = num;
        }
    }
}

//second Solution
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, temp = m + n- 1;
        while(i > -1 && j > -1){
            nums1[temp--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j > -1){
            nums1[temp--] = nums2[j--];
        }
    }
}
