/* Approach: design tic tac tow idea
* time complexity: O(nm), space complexity: O(nm)
*/
public class Solution {
    private int x = -1;
    private int y = -1;
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
