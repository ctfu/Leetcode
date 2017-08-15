/* Approach: BFS */
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        for (int i = 0; i < cols; i++) {
            visited[0][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            visited[rows - 1][i] = true;
            pq.offer(new Cell(rows - 1, i, heightMap[rows - 1][i]));
        }
        for (int i = 0; i < rows; i++) {
            visited[i][0] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][cols - 1] = true;
            pq.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
        }
        int[] direct = {0, 1, 0, -1, 0};
        int res = 0;
        while (!pq.isEmpty()) {
            Cell top = pq.poll();
            for (int k = 0; k < 4; k++) {
                int newX = top.x + direct[k];
                int newY = top.y + direct[k + 1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    res += Math.max(0, top.height - heightMap[newX][newY]);
                    pq.offer(new Cell(newX, newY, Math.max(top.height, heightMap[newX][newY])));
                }
            }
        }
        return res;

    }
    class Cell {
        int x;
        int y;
        int height;
        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
