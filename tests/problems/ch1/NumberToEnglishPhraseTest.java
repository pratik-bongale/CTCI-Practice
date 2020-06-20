package problems.ch1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberToEnglishPhraseTest {

    NumberToEnglishPhrase testObj;

    @BeforeEach
    void setUp() {
        testObj = new NumberToEnglishPhrase();
    }

    @ParameterizedTest
    @MethodSource("convertToPhrase_Parameters")
    void convertToPhrase(int n, String expectedPhrase) {
        assertEquals(expectedPhrase, testObj.convertToPhrase(n));
    }

    static Stream<Arguments> convertToPhrase_Parameters() {
        return Stream.of(
                Arguments.of(104, "One Hundred Four"),
                Arguments.of(0, "Zero"),
                Arguments.of(1, "One"),
                Arguments.of(10, "Ten"),
                Arguments.of(14, "Fourteen"),
                Arguments.of(67, "Sixty Seven"),
                Arguments.of(104, "One Hundred Four"),
                Arguments.of(729, "Seven Hundred Twenty Nine"),
                Arguments.of(1000, "One Thousand"),
                Arguments.of(4000, "Four Thousand"),
                Arguments.of(1040, "One Thousand Forty"),
                Arguments.of(3835, "Three Thousand Eight Hundred Thirty Five"),
                Arguments.of(10000, "Ten Thousand"),
                Arguments.of(20729, "Twenty Thousand Seven Hundred Twenty Nine"),
                Arguments.of(500000, "Five Hundred Thousand"),
                Arguments.of(743924, "Seven Hundred Forty Three Thousand Nine Hundred Twenty Four"),
                Arguments.of(4299724, "Four Million Two Hundred Ninety Nine Thousand Seven Hundred Twenty Four")
        );
    }

}