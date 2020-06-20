package problems.ch1;

public class SortedMatrixSearch {

    int[] find(int[][] matrix, int ele) {
        // given: matrix, sorted by rows and cols
        // return: location of ele in matrix

        // idea: you can eliminate a column if start of that col is greater than ele, same goes for rows
        // Approach: start from last column, move towards first
        //           if ele < arr[i,j] go left, else go down

        int nrows = matrix.length;
        int ncols = matrix[0].length;

        int[] res = new int[2];
        boolean elementFound = false;
        int r  = 0;
        int c = ncols-1;

        while( r >= 0 && r < nrows && c >= 0 && c < ncols ) {
            if( ele == matrix[r][c] ) {
                res[0] = r;
                res[1] = c;
                elementFound = true;
                break;
            } else if(ele < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }

        if(!elementFound) {
            res[0] = -1;
            res[1] = -1;
        }

        return res;

    }

    // TODO: Implement recursive version which uses binary search of diagonals to eliminate quadrants
}
