import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * ReverseBinary unit test
 */
@RunWith(Parameterized.class)
public class ReverseBinaryTest {
    private int input;
    private char[] binaryForm;
    private int output;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {13, 11},
                {128, 1},
                {47, 61},
                {589, 713}
        });
    }

    public ReverseBinaryTest(int input, int output) {
        this.input = input;
        this.binaryForm = Integer.toBinaryString(input).toCharArray();
        this.output = output;
    }

    @Test
    public void testToBinary() throws Exception {
        assertTrue(Arrays.equals(binaryForm, ReverseBinary.toBinary(input)));
    }

    @Test
    public void testReverse() throws Exception {
        assertEquals(output, ReverseBinary.reverse(input));
    }
}