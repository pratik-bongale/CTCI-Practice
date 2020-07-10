package problems.ch2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP4Test {

    private static Stream<Arguments> partitionSLL_Parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(3,4,1,5,2,4,7,-1), 3, Arrays.asList(-1,2,1,3,4,5,4,7)),
                Arguments.of(Arrays.asList(3,5), 3, Arrays.asList(3,5)),
                Arguments.of(Arrays.asList(3,5), 8, Arrays.asList(5,3)),
                Arguments.of(Arrays.asList(3,5), 1, Arrays.asList(3,5)),
                Arguments.of(Arrays.asList(3), 3, Arrays.asList(3))
        );
    }

    @ParameterizedTest
    @MethodSource("partitionSLL_Parameters")
    void whenTestingForEquality_ShouldBeEqual(List<Integer> actualArr, int x, List<Integer> expectedArr) {
        LinkedListP4<Integer> testObj =  new LinkedListP4<>();
        testObj.addAllFromList(actualArr);
        testObj.partitionSLL(x);
        assertEquals(expectedArr, testObj.toList());
    }
}