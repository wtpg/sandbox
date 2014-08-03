import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * FizzBuzz unit test
 */
@RunWith(Parameterized.class)
public class FizzBuzzTest {
    private int input;
    private String expected;
    private FizzBuzz fizzBuzzer;

    public FizzBuzzTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection inputN() {
        return Arrays.asList(new Object[][]{
                {2, "1 2"},
                {6, "1 2 Fizz 4 Buzz Fizz"},
                {19, "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19"},
                {22, "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22"},
                {5, "1 2 Fizz 4 Buzz"}
        });
    }

    @Before
    public void initialize() {
        fizzBuzzer = new FizzBuzz();
    }

    @Test
    public void testPrintFizzBuzzNumbers() throws Exception {
        assertEquals(expected, fizzBuzzer.printFizzBuzzNumbers(input));
    }
}
