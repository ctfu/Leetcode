/* Approach: transform nums array to string array for comparison, implement a string Comparator
 * time complexity: O(nlogn), space complexity: O(n)
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "0";
        }
        String[] numStr = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });
        if (numStr[0].equals("0")) {
            return "0";
        }
        for (String str : numStr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
