import java.util.*;

public class CourseSchedule {
    public boolean canFinish (int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];

        //Initialize edges
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        //build edges and degree based on prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            //pre --> cur
            map.put(prerequisites[i][1], new ArrayList<Integer>(prerequisites[i][0]));
        }

        //every vertex with initial 0 indegree
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            int n = map.get(course).size();
            for (int i = 0; i < n; i++) {
                int idx = (int)map.get(course).get(i);
                degree[idx]--;
                if (degree[idx] == 0) {
                    queue.add(idx);
                }
            }
        }

        return count == numCourses;
    }

    private Map<Integer, List<Integer>> createCourseMap(int numCourse, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourse; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        //pre --> cur
        for (int j = 0; j < prerequisites.length; j++) {
            int cur = prerequisites[j][0];
            int pre = prerequisites[j][1];
            map.get(pre).add(cur);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 6},
                {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        int numCourses = 8;

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean canFinish = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }

}
