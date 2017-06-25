/* If the citations are already sorted in assending order, we can use binary search */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int begin = 0, end = citations.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (citations[mid] >= citations.length - mid) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return citations.length - begin;
    }
}
