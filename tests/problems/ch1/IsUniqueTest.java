package problems.ch1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
* This test case uses JUnit 4 style parameterized testing
* Limitation: one class can only test one method*/

@RunWith(Parameterized.class)
public class IsUniqueTest {

    private String inputStr;
    private Boolean expectedResult;
    private IsUnique testObj;

    public IsUniqueTest(String inputStr, Boolean expectedResult) {
        this.inputStr = inputStr;
        this.expectedResult = expectedResult;
    }

    @Before     // executed before every single test
    public void setup() {
        testObj = new IsUnique();
    }

    @Test
    public void isUnique_whenASCIIStringInput_thenReturnsTrue() {
        assertEquals(expectedResult, testObj.isUnique(inputStr));
    }

    @Parameterized.Parameters
    public static Collection validParameters() {
        return Arrays.asList(new Object[][] {
                {"aksj skdj", false}, {"akytr", true}
        });
    }
}