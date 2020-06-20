package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MagicIndexTest {

    MagicIndex testObj;

    @BeforeEach
    void setUp() {
        testObj = new MagicIndex();
    }

    @ParameterizedTest
    @MethodSource("getMagicIndexFromDistinctArr_Parameters")
    void getMagicIndexFromDistinctArr(int[] arr, int expectedIndex) {
        assertEquals(expectedIndex, testObj.getMagicIndexFromDistinctArr(arr));
    }

    @ParameterizedTest
    @MethodSource("getMagicIndexFromArrayWithDuplicates_Parameters")
    void getMagicIndexFromArrayWithDuplicates(int[] arr, int expectedIndex) {
        assertEquals(expectedIndex, testObj.getMagicIndexFromArrayWithDuplicates(arr));
    }

    private static Stream<Arguments> getMagicIndexFromArrayWithDuplicates_Parameters() {

        int[] arr1 = {1,2,3,4,5};
        Arguments arg1 = Arguments.of(arr1, -1);

        int[] arr2 = {1,2,3,3,5,6,7,7,7,10};
        Arguments arg2 = Arguments.of(arr2, 3);

        int[] arr3 = {-1,0,1,2,3,4,5,7,9};
        Arguments arg3 = Arguments.of(arr3, 7);

        int[] arr4 = {-1,1};
        Arguments arg4 = Arguments.of(arr4, 1);

        int[] arr5 = {1};
        Arguments arg5 = Arguments.of(arr5, -1);

        int[] arr6 = {0};
        Arguments arg6 = Arguments.of(arr6, 0);

        return Stream.of(
                arg1, arg2, arg3, arg4, arg5, arg6
        );
    }

    private static Stream<Arguments> getMagicIndexFromDistinctArr_Parameters() {

        int[] arr1 = {1,2,3,4,5};
        Arguments arg1 = Arguments.of(arr1, -1);

        int[] arr2 = {-1,0,2,3,5,6,7,10};
        Arguments arg2 = Arguments.of(arr2, 3); // here we get 3 instead of 2 because we are using binary search

        int[] arr3 = {-1,0,1,2,3,4,5,7,9};
        Arguments arg3 = Arguments.of(arr3, 7);

        int[] arr4 = {-1,1};
        Arguments arg4 = Arguments.of(arr4, 1);

        int[] arr5 = {1};
        Arguments arg5 = Arguments.of(arr5, -1);

        int[] arr6 = {0};
        Arguments arg6 = Arguments.of(arr6, 0);

        return Stream.of(
                arg1, arg2, arg3, arg4, arg5, arg6
        );
    }
}