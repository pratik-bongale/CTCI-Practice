package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressorTest {

    StringCompressor testObj;

    @BeforeEach
    void setUp() {
        testObj = new StringCompressor();
    }

    @ParameterizedTest
    @MethodSource("compressString_Parameters")
    void compressString(String givenStr, String expectedStr) {
        String res = testObj.compressString(givenStr);
        assertEquals(expectedStr, res);
    }

    static Stream<Arguments> compressString_Parameters() {
        return Stream.of(
                Arguments.of("aaaaabb", "a5b2"),
                Arguments.of("aaab", "aaab"),
                Arguments.of("a", "a"),
                Arguments.of("abbbbbc", "a1b5c1"),
                Arguments.of("acacacac", "acacacac")
        );
    }
}