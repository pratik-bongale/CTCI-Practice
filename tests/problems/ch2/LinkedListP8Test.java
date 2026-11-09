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

class LinkedListP8Test {

    private static Stream<Arguments> DetectLoopStart_Parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7,8), 4, 5),
//                Arguments.of(Arrays.asList(1,2,3,4,5,6,7,8), null),
                Arguments.of(Arrays.asList(1,2), 0, 1),
                Arguments.of(Arrays.asList(1), 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("DetectLoopStart_Parameters")
    void DetectLoopStart(List<Integer> l, int connectToIndex, Integer expected) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAllFromList(l);
        ll.add(ll.getNodeAtIndex(connectToIndex));
        LinkedListP8<Integer> testObj = new LinkedListP8<>();
        LinkedList.Node<Integer> res =  testObj.detectLoopStart(ll);
        assertEquals(expected, res.data);
    }

    @Test
    void detectLoopStart_WhenNoLoop() {
        LinkedListP8<Integer> testObj = new LinkedListP8<>();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAllFromList(Arrays.asList(1,2,3,4,5,6,7,8));
        assertNull(testObj.detectLoopStart(ll));
    }
}