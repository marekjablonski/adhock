package exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciServicesTest {
    private FibonacciServices fs= new FibonacciServices(7);

    @ParameterizedTest
    @CsvSource({"2,1","4,3","7,13","10,55"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(Integer input, Integer expected) {
        Integer actualValue = fs.getFibonacci(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

}