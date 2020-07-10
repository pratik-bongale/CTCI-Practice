package problems.ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.ch2.util.LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP2Test {

    LinkedListP2<Integer> testObjInteger;

    private static Stream<Arguments> findKthToLastElement_Parameters() {
        return Stream.of(Arguments.of(Arrays.asList(1,2,3,4,5,6,7,8), 3, 5));
    }

    @BeforeEach
    void setUp() {
        testObjInteger = new LinkedListP2<>();
    }

    @ParameterizedTest
    @MethodSource("findKthToLastElement_Parameters")
    void findKthToLastElement(List<Integer> list, int k, int expected) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAllFromList(list);
        assertEquals(expected, testObjInteger.findKthToLastElement(ll, k));
    }


}