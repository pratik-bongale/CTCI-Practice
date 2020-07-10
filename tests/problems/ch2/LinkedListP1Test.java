package problems.ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.ch2.util.LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP1Test {

    LinkedListP1<Integer> testObjInteger;

    private static Stream<Arguments> removeDuplicates_Parameters() {
        return Stream.of(Arguments.of(Arrays.asList(1,2,3,4,5,6,4,4,6,2,1), Arrays.asList(1,2,3,4,5,6)));
    }

    @BeforeEach
    void setUp() {
        testObjInteger = new LinkedListP1<>();
    }

    @ParameterizedTest
    @MethodSource("removeDuplicates_Parameters")
    void removeDuplicates(List<Integer> listActual, List<Integer> listExpected) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAllFromList(listActual);

        // check O(N) space algorithm
        testObjInteger.removeDuplicates(ll);
        assertEquals(listExpected, ll.toList());

        // check O(1) space algorithm
        testObjInteger.removeDuplicatesNoExtraMemory(ll);
        assertEquals(listExpected, ll.toList());
    }
}