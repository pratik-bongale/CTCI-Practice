package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortedMatrixSearchTest {

    SortedMatrixSearch testObj;

    @BeforeEach
    void setUp() {
        testObj = new SortedMatrixSearch();
    }

    @ParameterizedTest
    @MethodSource("find_Parameters")
    void find(int[][] mat, int key, int[] expectedRes) {

        int[] res = testObj.find(mat, key);
        assertArrayEquals(expectedRes, res);
    }

    static Stream<Arguments> find_Parameters() {

        int[][] mat1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int key = 9;
        int[] expected1 = {2,0};
        Arguments arg1 = Arguments.of(mat1, key, expected1);

        int[][] mat2 = {{-1,3,6,6,6},{3,3,9,10,19},{7,12,12,15,20}};
        key = 11;
        int[] expected2 = {-1,-1};
        Arguments arg2 = Arguments.of(mat2, key, expected2);

        int[][] mat3 = {{-1,-1}, {1,1}};
        key = -1;
        int[] expected3 = {0,1};
        Arguments arg3 = Arguments.of(mat3, key, expected3);

        int[][] mat4 = {{1}};
        key = 1;
        int[] expected4 = {0,0};
        Arguments arg4 = Arguments.of(mat4, key, expected4);

        int[][] mat5 = {{1}};
        key = 2;
        int[] expected5 = {-1,-1};
        Arguments arg5 = Arguments.of(mat5, key, expected5);

        return Stream.of(
                arg1, arg2, arg3, arg4, arg5
        );
    }



}