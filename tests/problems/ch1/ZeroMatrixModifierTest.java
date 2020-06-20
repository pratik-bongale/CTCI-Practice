package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ZeroMatrixModifierTest {

    ZeroMatrixModifier testObj;

    @BeforeEach
    void setUp() {
        testObj = new ZeroMatrixModifier();
    }

    @ParameterizedTest
    @MethodSource("zeroMatrix_Parameters")
    void zeroMatrix(int[][] matrix, int[][] expected) {
        testObj.zeroMatrix(matrix);
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                assertEquals(expected[i][j], matrix[i][j]);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("zeroMatrix_Parameters")
    void zeroMatrixNoExtraSpace(int[][] matrix, int[][] expected) {
        testObj.zeroMatrixNoExtraSpace(matrix);
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                assertEquals(expected[i][j], matrix[i][j]);
            }
        }
    }

    static Stream<Arguments> zeroMatrix_Parameters() {

        int[][] m1 = {
                {1,2,1},
                {1,0,0},
                {3,1,3},
                {1,4,0}
        };

        int[][] m1Expected = {
                {1,0,0},
                {0,0,0},
                {3,0,0},
                {0,0,0}
        };
        Arguments a1 = Arguments.of(m1,m1Expected);

        int[][] m2 = {
                {7 ,6 ,7 ,9 ,5 ,9},
                {8 ,6 ,6 ,4 ,2 ,9},
                {7 ,3 ,7 ,0 ,2 ,6},
                {1 ,2 ,7 ,1 ,2 ,8}
        };

        int[][] m2Expected = {
                {7 ,6 ,7 ,0 ,5 ,9},
                {8 ,6 ,6 ,0 ,2 ,9},
                {0 ,0 ,0 ,0 ,0 ,0},
                {1 ,2 ,7 ,0 ,2 ,8}
        };

        Arguments a2 = Arguments.of(m2, m2Expected);

        int[][] m3 = {
                {1}
        };
        Arguments a3 = Arguments.of(m3, m3);

        int[][] m4 = {
                {0}
        };
        Arguments a4 = Arguments.of(m4, m4);

        int[][] m5 = {
                {0,0}
        };
        Arguments a5 = Arguments.of(m5, m5);

        return Stream.of(a1, a2, a3, a4, a5);

    }
}