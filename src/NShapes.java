import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NShapes {
    public static ArrayList<ArrayList<Point>> coordinatesOfShapes(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }

        ArrayList<ArrayList<Point>> results = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    ArrayList<Point> currentShapeCoordinates = new ArrayList<Point>();
                    bfs(grid, visited, i, j, currentShapeCoordinates);
                    results.add(currentShapeCoordinates);
                }
            }
        }
        return results;
    }

    private static void bfs(int[][] grid, boolean[][] v, int sx, int sy, ArrayList<Point> currentShapeCoordinates) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(sx);
        qy.offer(sy);
        v[sx][sy] = true;
        currentShapeCoordinates.add(new Point(sx, sy));

        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < grid.length
                        && 0 <= ny && ny < grid[0].length
                        && !v[nx][ny] && grid[nx][ny] == 0) {
                    qx.offer(nx);
                    qy.offer(ny);
                    v[nx][ny] = true;
                    currentShapeCoordinates.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        for(ArrayList<Point> shape : coordinatesOfShapes(grid)) {
            System.out.println("This shape coodinates are: ");
            for (Point coordinate : shape) {
                System.out.println(coordinate.x + "," + coordinate.y);
            }
        }

    }

}
