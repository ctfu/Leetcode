/* Binary search:
the key is to search the begin element's index of the final return k elemets
time complexity: O(logn)
space complexity: O(1)
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // arr.length - k indicats the max index the begin elemet's index can be
        int begin = 0, end = arr.length - k;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (x > arr[mid]) {
                //check if x is left size of right size of interval arr[mid]
                if (x - arr[mid] > arr[mid + k] - x) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        int index = begin;
        while (k != 0) {
            res.add(arr[index++]);
            k--;
        }
        return res;
    }
}
