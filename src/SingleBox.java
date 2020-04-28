import java.util.ArrayList;

public class SingleBox {
    public static void GetSingleBox(int[][] image) {
        int x = 0;
        int y = 0;

        int width = 0;
        int height = 0;

        int rows = image.length;
        int columns  = image[0].length;

        boolean isFound = false;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (image[i][j] == 0) {
                    x = i;
                    y = j;
                    System.out.println("Top-left point coordinates is: " + i + "," + j);
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                break;
            }

        }

        for (int i = x; i < rows; i++) {
            if (image[i][y] == 0) {
                height++;
            }
        }

        for (int j = y; j < columns; j++) {
            if (image[x][j] == 0) {
                width++;
            }
        }

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);


        ArrayList<Point> arr = new ArrayList<Point>(2);
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (image[i][j] == 0) {
                    if (arr.size() > 0) {
                        arr.add(1, new Point(i, j));
                    } else {
                        arr.add(0, new Point(i, j));
                    }
                }
            }

        }

        System.out.println("Top-left point coodinates is: " + arr.get(0).x+ "," + arr.get(0).y);
        System.out.println("Bottom-right point coodinates is: " + arr.get(1).x + "," + arr.get(1).y);

    }

    public static void main(String[] args) {
        int[][] image = new int[][] {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        GetSingleBox(image);

    }
}

