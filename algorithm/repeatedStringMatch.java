class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        while (sb.length() < B.length()) { // make sure A has enough length to be search by B
            sb.append(A);
            count++;
        }
        if (sb.indexOf(B) >= 0) {
            return count;
        }
        // if not found, append one more time, so exhauste every index of A to search for B
        sb.append(A);
        if (sb.indexOf(B) >= 0) {
            return count + 1;
        }
        // if not found, then B won't be possible to be substring of A
        return -1;
    }
}
