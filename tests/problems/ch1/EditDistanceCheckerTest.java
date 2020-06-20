package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceCheckerTest {

    private EditDistanceChecker testObj;

    @BeforeEach
    void setUp() {
        testObj = new EditDistanceChecker();
    }

    @ParameterizedTest
    @MethodSource("isOneEditAway_Parameters")
    void isOneEditAway(String s1, String s2, boolean expectedRes) {
        boolean res = testObj.isOneEditAway(s1, s2);
        assertEquals(expectedRes, res);
    }

    static Stream<Arguments> isOneEditAway_Parameters() {
        return Stream.of(
                Arguments.of("abcd", "abcc", true),
                Arguments.of("bbcd", "bbcd", true),
                Arguments.of("abcd", "bbcq", false),
                Arguments.of("abc", "abcd", true),
                Arguments.of("bcd", "abcd", true),
                Arguments.of("abcd", "bcd", true),
                Arguments.of("bcd", "abd", false),
                Arguments.of("abcd", "abcc", true)
        );
    }
}