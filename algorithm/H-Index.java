/* Apporach: sorting, the critical condition to return is when amout of citations >= number of papers
 * time complexity: O(nlogn), space complexity: o(1)
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}

/* To improve it O(n), using extra sapce in sorting, counting sort */
public class Solution {
    public int hIndex(int[] citations) {
        int[] papers = new int[citations.length+1];
        for (int c : citations) {
            if (c > citations.length) {
                papers[citations.length] += 1;
            } else {
                papers[c] += 1;
            }
        }
        int p = 0;
        for (int i = papers.length-1; i >= 0; i--) {
            p += papers[i];
            if (p >= i) {
                return i;
            }
        }
        return 0;
    }
}
