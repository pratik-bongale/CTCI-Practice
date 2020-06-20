package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    RotateMatrix testObj;

    @BeforeEach
    void setUp() {
        testObj = new RotateMatrix();
    }

    @ParameterizedTest
    @MethodSource("rotateMatrixInplace_Parameters")
    void rotateMatrixInplace(int[][] matrix, int[][] expectedMatrix) {

        testObj.rotateMatrix(matrix);

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[0].length; j++) {
                assertEquals(expectedMatrix[i][j], matrix[i][j]);
            }
        }

    }

    @ParameterizedTest
    @MethodSource("rotateMatrixInplace_Parameters")
    void rotateMatrixInplaceOnePass(int[][] matrix, int[][] expectedMatrix) {

        testObj.rotateMatrixOnePass(matrix);

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[0].length; j++) {
                assertEquals(expectedMatrix[i][j], matrix[i][j]);
            }
        }

    }



    static Stream<Arguments> rotateMatrixInplace_Parameters() {
        int[][] mat2x2 = {{1,2},{3,4}};
        int[][] expected2x2 = {{3,1},{4,2}};
        Arguments a1 = Arguments.of(mat2x2, expected2x2);

        int[][] mat3x3 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] expected3x3 = {{7,4,1}, {8,5,2}, {9,6,3}};
        Arguments a2 = Arguments.of(mat3x3, expected3x3);

        int[][] mat4x4 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] expected4x4 = {{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4}};
        Arguments a3 = Arguments.of(mat4x4, expected4x4);

        return Stream.of(
                a1, a2, a3
        );
    }
}