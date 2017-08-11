public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int rows = rooms.length, cols = rooms[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * cols + j);
                    while (!queue.isEmpty()) {
                        int top = queue.poll();
                        int[] direct = {0, 1, 0, -1, 0};
                        for (int k = 0; k < 4; k++) {
                            int x = top / cols + direct[k], y = top % cols + direct[k + 1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && rooms[x][y] != -1
                                && rooms[x][y] != 0 && rooms[x][y] > rooms[top / cols][top % cols] + 1) {
                                rooms[x][y] = rooms[top / cols][top % cols] + 1;
                                queue.offer(x * cols + y);
                            }
                        }
                    }
                }
            }
        }
    }
}
