package problems.ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.ch2.util.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP6Test {

    LinkedListP6<Integer> testObjInteger;
    LinkedListP6<Character> testObjString;

    private static Stream<Arguments> IsPalindromeIntegers_Parameters() {

        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,2,1), true),
                Arguments.of(Arrays.asList(1,2,3,2,4), false),
                Arguments.of(Arrays.asList(1,2,1), true),
                Arguments.of(Arrays.asList(1), true),
                Arguments.of(Arrays.asList(1,2,3,3,2,1), true),
                Arguments.of(Arrays.asList(4,4,4,4,4,5), false)
        );
    }

    private static Stream<Arguments> IsPalindromeCharacters_Parameters() {
        return Stream.of(
                Arguments.of("abcba", true),
                Arguments.of("madam", true),
                Arguments.of("aaaaaaa", true),
                Arguments.of("ababab", false)
        );
    }

    @BeforeEach
    void setUp() {
        testObjInteger = new LinkedListP6<>();
        testObjString = new LinkedListP6<>();
    }

    @ParameterizedTest
    @MethodSource("IsPalindromeIntegers_Parameters")
    void IsPalindromeIntegers(List<Integer> numbers, boolean expected) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAllFromList(numbers);
        assertEquals(expected, testObjInteger.isPalindrome(ll));
    }

    @ParameterizedTest
    @MethodSource("IsPalindromeCharacters_Parameters")
    void IsPalindromeCharacters(String s, boolean expected) {
        char[] chArr = s.toCharArray();
        List<Character> l = new ArrayList<>();
        for (char c : chArr) {
            l.add(c);
        }
        LinkedList<Character> ll = new LinkedList<>();
        ll.addAllFromList(l);
        assertEquals(expected, testObjString.isPalindrome(ll));
    }
}