/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n, firstBad = n;
        while(start <= end){
            int mid = start + (end - start) /2; //dont use (start + edn) /2 for the midpoint, it can cause overflow
            if(isBadVersion(mid)){
                firstBad = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return firstBad;
    }
}
