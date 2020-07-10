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

class LinkedListP3Test {

    LinkedListP3<Integer> testObjInteger;

    private static Stream<Arguments> deleteNode_Parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5), 2, Arrays.asList(1,2,4,5)),
                Arguments.of(Arrays.asList(1,1,1), 1, Arrays.asList(1,1))
        );
    }

    @BeforeEach
    void setUp() {
        testObjInteger = new LinkedListP3<>();
    }

    @ParameterizedTest
    @MethodSource("deleteNode_Parameters")
    void deleteNode(List<Integer> listActual, int indexToRemove, List<Integer> listExpected) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAllFromList(listActual);
        LinkedList.Node<Integer> nodeToRemove = ll.getNodeAtIndex(indexToRemove);
        testObjInteger.deleteNode(nodeToRemove);
        assertEquals(listExpected, ll.toList());
    }
}