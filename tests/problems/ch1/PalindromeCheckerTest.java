package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    PalindromeChecker testObj;

    @BeforeEach
    void setUp() {
        testObj = new PalindromeChecker();
    }

    @ParameterizedTest
    @MethodSource("isPermutationOfPalindrome_Parameters")
    void isPermutationOfPalindrome(String input, boolean expectedRes) {
        boolean res = testObj.isPermutationOfPalindrome(input);
        assertEquals(expectedRes, res);
    }

    static Stream<Arguments> isPermutationOfPalindrome_Parameters() {
        return Stream.of(
                Arguments.of("aabbccdd", true),
                Arguments.of("aabbcddee", true),
                Arguments.of("aa bb dd wer skdjbc ajsx", false),
                Arguments.of("aksld aksld", true)
        );
    }
}