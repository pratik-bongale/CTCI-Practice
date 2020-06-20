package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SubstringCheckerTest {

    SubstringChecker testObj;

    @BeforeEach
    void setUp() {
        testObj = new SubstringChecker();
    }

    @ParameterizedTest
    @MethodSource("isRotation_Parameters")
    void isRotation(String s1, String s2, boolean expected) {
        assertEquals(expected, testObj.isRotation(s1, s2));
    }

    static Stream<Arguments> isRotation_Parameters() {
        return Stream.of(
                Arguments.of("waterbottle", "erbottlewat", true),
                Arguments.of("ababababc", "abcababab", true),
                Arguments.of("abcde", "cdeac", false),
                Arguments.of("aabcd", "weoinasm", false)
        );
    }
}