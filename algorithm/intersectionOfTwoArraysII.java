/* sort the two array and use two pointers */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else{
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
