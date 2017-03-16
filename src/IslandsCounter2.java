/**
 * Created by Sergey on 3/11/2017.
 */
public class IslandsCounter2 {

    int matrix[][];
    boolean isVisited[][];
    int counter;

    int[] verticalShift = {0, 1, 0, -1};
    int[] horizontalShift = {1, 0, -1, 0};

    IslandsCounter2(int matrix[][]) {
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
        IslandsCounter2 counter = new IslandsCounter2(
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

    // iterate all matrix and find 1
    int countIslands() {
        // main loop
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !isVisited[i][j]) {
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


    // check boundary
    boolean isSafe(int row, int col) {

        if (row < 0 || col < 0 || row == matrix.length || col == matrix.length) {
            return false;
        }

        return true;
    }


    // recursive function explore cells with 1s and marks all visited cells
    void exploreIsland(int row, int col) {


        isVisited[row][col] = true;


        for (int i = 0; i < horizontalShift.length; i++) {
            int nextRow = row + verticalShift[i];
            int nextCol = col + horizontalShift[i];

            if (isSafe(nextRow, nextCol)) {
                if (!isVisited[nextRow][nextCol]) {
                    isVisited[nextRow][nextCol] = true;
                    if (matrix[nextRow][nextCol] == 1) {
                        exploreIsland(nextRow, nextCol);
                    }
                }

            }
        }


    }
}
