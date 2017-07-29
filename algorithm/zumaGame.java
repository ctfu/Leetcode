public class Solution {
    private int maxInsert = 6; /* max balls at hand are 5, insertion at most 5 */
    public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            count[hand.charAt(i) - 'A']++;
        }
        int res = insert(board + "#", count); /* added # to avoid when j = board.length() */
        return res == maxInsert ? -1 : res;
    }
    public int insert(String board, int[] count) {
        board = removeConsecutive(board);
        if (board.equals("#")) {
            return 0;
        }
        int res = maxInsert, neededInsert = 0;
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) {
                continue;
            }
            neededInsert = 3 - (j - i);
            if (count[board.charAt(i) - 'A'] >= neededInsert) {
                count[board.charAt(i) - 'A'] -= neededInsert;
                res = Math.min(res, neededInsert + insert(board.substring(0, i) + board.substring(j), count));
                count[board.charAt(i) - 'A'] += neededInsert;
            }
            i = j;
        }
        return res;
    }
    /* remove consecutive chars that are longer than 3 */
    public String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) {
                continue;
            }
            if (j - i >= 3) {
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }
        return board;
    }
}
