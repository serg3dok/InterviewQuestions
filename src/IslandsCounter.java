/**
 * Created by Sergey on 3/11/2017.
 */
public class IslandsCounter {

    int matrix[][];
    boolean isVisited[][];
    int counter;

    int[] verticalShift = {0, 1, 0, -1};
    int[] horizontalShift = {1, 0, -1, 0};

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
                else {
                    isVisited[i][j] = true;
                }
            }
        }

        return counter;
    }

    boolean isSafe(int row, int col) {

        // out of boundary
        if (row < 0 || col  < 0 || col == matrix.length - 1 || col == matrix.length - 1 ) {
            return false;
        }

        // already visited
        if (isVisited[row][col]) {
            return false;
        }

        isVisited[row][col] = true;

        if ( matrix[row][col] != 1) {
            return false;
        }

        return true;
    }

    void exploreIsland(int row, int col) {



        isVisited[row][col] = true;

        if (!isVisited[row][col] || matrix[row][col] == 1) {

        }

        for (int i = 0; i < horizontalShift.length; i++) {
            if (isSafe(row + verticalShift[i], col + horizontalShift[i])) {

                exploreIsland(row + verticalShift[i], col + horizontalShift[i]);
            }
        }


    }
}
