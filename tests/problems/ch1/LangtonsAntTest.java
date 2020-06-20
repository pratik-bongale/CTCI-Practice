package problems.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LangtonsAntTest {

    LangtonsAnt testObj;

    @BeforeEach
    void init() {
        testObj = new LangtonsAnt();
    }

    @ParameterizedTest
    @MethodSource("printKMoves_Parameters")
    void printKMoves(int k) {
        System.out.println("K:" + k);
        testObj.printKMoves(k);
    }

    static Stream<Arguments> printKMoves_Parameters() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4),
//                Arguments.of(5),
                Arguments.of(8),
                Arguments.of(12),
                Arguments.of(16),
                Arguments.of(20),
                Arguments.of(24),
                Arguments.of(35),
                Arguments.of(50)
        );
    }

}