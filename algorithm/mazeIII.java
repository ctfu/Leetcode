/* Take each cell in the matric as a Point object */
public class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int rows = maze.length, cols = maze[0].length;
        Point[][] points = new Point[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                points[i][j] = new Point(i, j);
            }
        }
        Queue<Point> queue = new LinkedList<>();
        int[] direct = {0, 1, 0, -1, 0};
        String[] path = {"r", "d", "l", "u"};
        queue.offer(new Point(ball[0], ball[1], 0, ""));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (points[p.x][p.y].compareTo(p) <= 0) {
                continue;
            }
            points[p.x][p.y] = p;
            for (int k = 0; k < 4; k++) {
                int distance = p.distance;
                int newX = p.x + direct[k], newY = p.y + direct[k + 1];
                while (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == 0
                       && (newX != hole[0] || newY != hole[1])) {
                    newX += direct[k];
                    newY += direct[k + 1];
                    distance++;
                }
                if (newX != hole[0] || newY != hole[1]) { // if not in the hole, need to roll back one step
                    newX -= direct[k];
                    newY -= direct[k + 1];
                }
                queue.offer(new Point(newX, newY, distance, p.path + path[k]));
            }
        }
        return points[hole[0]][hole[1]].distance == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].path;
    }
    class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;
        String path;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Integer.MAX_VALUE;
            this.path = "";
        }
        public Point(int x, int y, int distance, String path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }
        @Override
        public int compareTo(Point p) {
            return this.distance == p.distance ? this.path.compareTo(p.path) : this.distance - p.distance;
        }
    }
}
