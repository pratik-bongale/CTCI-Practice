package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
* This uses JUnit5 style parameterized tests
* */

class IsPermutationTest {

    private IsPermutation testObj;

    @BeforeEach
    void setUp() {
        testObj = new IsPermutation();
    }

    @ParameterizedTest(name="Run {index}: s1={0}, s2={1}, expectedRes={2}")
    @MethodSource("testIsPermutation_Parameters")
    void isPermutation(String s1, String s2, boolean expectedRes) {
        boolean computedRes = testObj.isPermutation(s1,s2);
        assertEquals(expectedRes, computedRes);
    }

    static Stream<Arguments> testIsPermutation_Parameters() {
        return Stream.of(
                Arguments.of("sam", "max", false),
                Arguments.of("yummy", "tummy", false),
                Arguments.of("qwerty", "ytrewq", true)
        );
    }
}