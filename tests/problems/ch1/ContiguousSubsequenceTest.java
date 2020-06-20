package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContiguousSubsequenceTest {

    ContiguousSubsequence testObj;

    @BeforeEach
    void setUp() {
        testObj = new ContiguousSubsequence();
    }

    @ParameterizedTest
    @MethodSource("getContinuousSubsequenceWithLargestSum_Parameters")
    void getContinuousSubsequenceWithLargestSum(int[] arr, int expectedSum) {

        assertEquals(expectedSum,testObj.getContinuousSubsequenceWithLargestSum(arr));
    }

    static Stream<Arguments> getContinuousSubsequenceWithLargestSum_Parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1,3,-1,2,-3}, 4),
                Arguments.of(new int[]{2,-8,3,-2,4,-10}, 5),
                Arguments.of(new int[]{-1,-3,-1,-2,-3}, 0),
                Arguments.of(new int[]{0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getContinuousSubsequenceWithLargestSumHandlesAllNeg_Parameters")
    void getContinuousSubsequenceWithLargestSumHandlesAllNeg(int[] arr, int expectedSum) {

        assertEquals(expectedSum,testObj.getContinuousSubsequenceWithLargestSumHandlesAllNeg(arr));
    }

    static Stream<Arguments> getContinuousSubsequenceWithLargestSumHandlesAllNeg_Parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1,3,-1,2,-3}, 4),
                Arguments.of(new int[]{2,-8,3,-2,4,-10}, 5),
                Arguments.of(new int[]{-1,-3,-1,-2,-3}, -1),
                Arguments.of(new int[]{-8,-7,-6,-5,-4}, -4),
                Arguments.of(new int[]{0,0,0,0}, 0)
        );
    }



}