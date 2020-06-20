package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class URLParserTest {

    private URLParser parser;

    @BeforeEach
    void setUp() {
        parser = new URLParser();
    }

    @ParameterizedTest(name="Run {index}: input={0}, trueLength={1}, expected={2}")
    @MethodSource("URLifyParameters")
    void URLify(String url, int trueLength, String modifiedUrl) {
        String res = parser.URLify(url, trueLength);
        assertEquals(modifiedUrl, res);
    }

    static Stream<Arguments> URLifyParameters() {
        return Stream.of(
                Arguments.of("abc qpr  ", 7, "abc%20qpr"),
                Arguments.of(" qq qq qq      ", 9, "%20qq%20qq%20qq")
        );
    }
}