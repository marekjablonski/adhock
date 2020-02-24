import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseArrayTest {

    ReverseArray ra = new ReverseArray();

    @ParameterizedTest
    @MethodSource("arraysProvider")
    void testArrayIsReversed(Object[] inputArray, Object[] expectedReversedArray) {
        Object[] reverseArray = ra.reverseArray(inputArray);
        assertTrue(Arrays.deepEquals(reverseArray, expectedReversedArray));

    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }


    static Stream<Arguments> arraysProvider() {
       return Stream.of(
                arguments(new String[]{"banana", "orange", "apple"}, new String[]{"apple", "orange", "banana"}),
               arguments(new String[]{"banana", "orange",null, "apple"}, new String[]{"apple",null, "orange", "banana"}),
               arguments(new Integer[]{1,2,3}, new Integer[]{3,2,1})
        );
    }

}