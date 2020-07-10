package problems.ch2.util;

import org.junit.jupiter.api.Test;
import problems.ch2.LinkedListP7;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP7Test {

    LinkedListP7<Integer> testObj = new LinkedListP7<>();

    @Test
    void HasIntersection() {
        LinkedList<Integer> ll1 = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();

        // test 1
        ll1.addAllFromList(Arrays.asList(0,1,2,3,4,5,6,7,8));
        ll2.addAllFromList(Arrays.asList(10,20,30));
        ll2.add(ll1.getNodeAtIndex(6));

        assertTrue(testObj.hasIntersection(ll1, ll2));

        // test 2
        ll1.clear();
        ll2.clear();
        ll1.addAllFromList(Arrays.asList(0,1,2,3,4,5,6,7,8));
        ll2.addAllFromList(Arrays.asList(4,3,5,2,5,1,6,3));

        assertFalse(testObj.hasIntersection(ll1, ll2));
    }
}