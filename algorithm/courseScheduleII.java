/* Topological Sort
*/
// Approach 1
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int[] course : prerequisites) {
            int ready = course[0];
            int pre = course[1];
            indegree[ready]++;
            matrix[pre][ready] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            res.add(top);
            for (int i = 0; i < numCourses; i++) {
                if (matrix[top][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        if (res.size() == numCourses) {
            int[] list = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                list[i] = res.get(i);
            }
            return list;
        }
        return new int[0];
    }
}

// approach 2
public class Solution {
    private int N = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i], result)) {
                return new int[0];
            }
        }
        return result;
    }

    private boolean isCyclic(Course cur, int[] result) {
        if (cur.tested == true) return false;
        if (cur.visited == true) return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c, result)) {
                return true;
            }
        }
        cur.tested = true;
        result[N++] = cur.number;
        return false;
    }

    class Course {
        boolean visited = false;
        boolean tested = false;
        int number;
        List<Course> pre = new ArrayList<Course>();
        public Course(int i) {
            number = i;
        }
        public void add(Course c) {
            pre.add(c);
        }
    }
}
