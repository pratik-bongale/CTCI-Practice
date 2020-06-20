package problems.ch1;

public class RotateMatrix {

    void rotateMatrix(int[][] matrix) {

        int n = matrix.length-1;
        int temp = 0;

        // flip along the diagonal
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n-i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][n-i];
                matrix[n-j][n-i] = temp;
            }
        }

        for (int i = 0; i <= n/2; i++) {
            for(int j = 0; j <= n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-i][j];
                matrix[n-i][j] = temp;
            }
        }
    }

    void rotateMatrixOnePass(int[][] matrix) {
        // taken form CTCI

        int n = matrix.length;

        // think of matrix as layers going inwards
        // layer 0 is the outermost layer starting at 00 .. nn
        // layer 1 will go from 11 .. n-1n-1

        for(int layer = 0; layer < n/2; layer++) {
            int first = layer;  // first element in current layer
            int last = n-1-layer;  // last element in current layer

            for (int i = first; i < last; i++) {
                int offset = i-first;  // we need this because i does not start from 0

                int top = matrix[first][i];

                // left to top
                matrix[first][i] = matrix[last-offset][first];

                // bottom to left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right to bottom
                matrix[last][last-offset] = matrix[i][last];

                // top to right
                matrix[i][last] = top;
            }
        }

    }
}
