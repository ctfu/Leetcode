/* seet the discussion for detail explanation */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        int iMin = 0, iMax = m;
        int maxLeft = 0, minRight = 0;
        while(iMin <= iMax){ /* it is very important here iMin <= iMax */
            i = iMin + (iMax-iMin)/2;
            j = (m+n+1)/2 - i;
            if(i < m && nums2[j-1] > nums1[i]){
                iMin = i+1;
            }else if(i > 0 && nums1[i-1] > nums2[j]){
                iMax = i-1;
            }else{
                if(i == 0){
                    maxLeft = nums2[j-1];
                }else if(j == 0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                break;
            }
        }
        if((m+n) % 2 != 0) return maxLeft; /* if there are totally odd number of numbers */

        if(i == m){
            minRight = nums2[j];
        }else if(j == n){
            minRight = nums1[i];
        }else{
            minRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft+minRight)/2.0;
    }
}
