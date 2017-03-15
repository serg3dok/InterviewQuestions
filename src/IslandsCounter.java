import java.util.Arrays;

/**
 * Created by Sergey on 3/11/2017.
 */
public class IslandsCounter {

    int matrix[][];
    boolean isVisited[][];
    int counter;

    IslandsCounter(int matrix[][]) {
        isVisited = new boolean[matrix.length][matrix[0].length];
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        int counter = 0;
    }


    public static void main(String[] args) {
        IslandsCounter counter = new IslandsCounter(
                new int[][]{
                        {0, 1, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1},
                        {0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {1, 1, 1, 1, 0, 0}
                }
        );

        System.out.println(counter.countIslands());
    }

    int countIslands() {
        // main loop
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && isVisited[i][j] == false) {
                    counter++;
                    //isVisited[i][j] = true;
                    exploreIsland(i, j);
                }
            }
        }

        return counter;
    }


    void exploreIsland(int y, int x) {

        if (matrix[y][x] == 1 && !isVisited[y][x]) { // explore right
            isVisited[y][x] = true;
            if (x < matrix.length - 1) exploreIsland(y, ++x);
        }
        else if (matrix[y][x] == 1 && !isVisited[y][x]) { // explore down
            isVisited[y][x] = true;
            if (y < matrix.length - 1) exploreIsland(y, ++x);
        }
        else if (matrix[y][x] == 1 && !isVisited[y][x]) { // explore left
            isVisited[y][x] = true;
            if (x > 0) exploreIsland(--y, x);
        }
        else if (matrix[y][x] == 1 && !isVisited[y][x]) { // explore up
            isVisited[y][x] = true;
            if (x > 0) exploreIsland(y, --x);
        }
    }
}
