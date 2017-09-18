/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/* Note: according to the question:
if a knows b, then a won't be candidate, if not then b won't be candiate */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)) // if true, anyone before i won't be candidate
                candidate = i;
        } // after the for loop, anyone after i won't be candidate
        // verify if the selected candidate is the real celebrity
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}
