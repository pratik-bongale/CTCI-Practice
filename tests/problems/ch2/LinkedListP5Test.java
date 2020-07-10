package problems.ch2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.ch2.util.LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP5Test {

    private static Stream<Arguments> addLL_Parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(5,7,9)),  // 321 + 654 = 975
                Arguments.of(Arrays.asList(5), Arrays.asList(6), Arrays.asList(1,1)),
                Arguments.of(Arrays.asList(6), Arrays.asList(6), Arrays.asList(2,1)),
                Arguments.of(Arrays.asList(0,0,0,0,1), Arrays.asList(0,0,2), Arrays.asList(0,0,2,0,1)),
                Arguments.of(Arrays.asList(0,0,2), Arrays.asList(0,0,0,0,1), Arrays.asList(0,0,2,0,1)),
                Arguments.of(Arrays.asList(9,9,9), Arrays.asList(1), Arrays.asList(0,0,0,1))
        );
    }

    private static Stream<Arguments> AddLLNonReversedRecursive_Parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(5,7,9)),  // 321 + 654 = 975
                Arguments.of(Arrays.asList(5), Arrays.asList(6), Arrays.asList(1,1)),
                Arguments.of(Arrays.asList(6), Arrays.asList(6), Arrays.asList(1,2)),
                Arguments.of(Arrays.asList(1,0,0,0,0), Arrays.asList(2,0,0), Arrays.asList(1,0,2,0,0)),
                Arguments.of(Arrays.asList(2,3,4), Arrays.asList(9,9,9,9,9,9), Arrays.asList(1,0,0,0,2,3,3)),
                Arguments.of(Arrays.asList(9,9,9), Arrays.asList(1), Arrays.asList(1,0,0,0))
        );
    }

    @ParameterizedTest
    @MethodSource("addLL_Parameters")
    void addLL(List<Integer> num1, List<Integer> num2, List<Integer> sum) {
        // both linked lists have number in reverse

        LinkedListP5 testObj = new LinkedListP5();

        LinkedList<Integer> num1Reverse = new LinkedList<>();
        num1Reverse.addAllFromList(num1);
        LinkedList<Integer> num2Reverse = new LinkedList<>();
        num2Reverse.addAllFromList(num2);

        assertEquals(sum, testObj.addLL(num1Reverse, num2Reverse).toList());            // test iterative solution
        assertEquals(sum, testObj.addLLRecursive(num1Reverse, num2Reverse).toList());   // test recursive solution
    }

    @ParameterizedTest
    @MethodSource("AddLLNonReversedRecursive_Parameters")
    void AddLLNonReversedRecursive(List<Integer> num1, List<Integer> num2, List<Integer> sum) {
        LinkedListP5 testObj = new LinkedListP5();

        LinkedList<Integer> num1Reverse = new LinkedList<>();
        num1Reverse.addAllFromList(num1);
        LinkedList<Integer> num2Reverse = new LinkedList<>();
        num2Reverse.addAllFromList(num2);

        assertEquals(sum, testObj.addLLNonReversedRecursive(num1Reverse, num2Reverse).toList());
    }
}
