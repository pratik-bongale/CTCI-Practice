package problems.ch1;

import java.util.HashSet;

public class ZeroMatrixModifier {

    void zeroMatrix(int[][] matrix) {
        // given MxN matrix, if one element is 0, make that row and col = 0

        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    void zeroMatrixNoExtraSpace(int[][] matrix) {
        // here we will use only the first row and first column to store information if a row/col has a 0

        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        // first find if the first row has a zero
        boolean rowHasZero = false;
        for (int i = 0; i < n; i++) {
            if( matrix[0][i] == 0 ) { rowHasZero = true; break; }
        }

        // find if the first col has a zero
        boolean colHasZero = false;
        for (int i = 0; i < m; i++) {
            if( matrix[i][0] == 0 ) { colHasZero = true; break; }
        }

        // now start traversing the remaining matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // now start setting 0s
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) nullifyCol(matrix, i);
        }

        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) nullifyRow(matrix, i);
        }

        if (rowHasZero) nullifyRow(matrix, 0);
        if (colHasZero) nullifyCol(matrix, 0);


    }

    void nullifyRow(int[][] matrix, int r) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[r][i] = 0;
        }
    }

    void nullifyCol(int[][] matrix, int c) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }
    }



}
