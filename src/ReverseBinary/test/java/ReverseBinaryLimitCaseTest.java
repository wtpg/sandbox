import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ReverseBinary unit test to test limit cases when wrong input provided
 */
@RunWith(Parameterized.class)
public class ReverseBinaryLimitCaseTest {
    private int input;
    private boolean shallFail;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {0, true},
                {-1, true},
                {ReverseBinary.UPPER_LIMIT, false},
                {ReverseBinary.UPPER_LIMIT + 1, true}
        });
    }

    public ReverseBinaryLimitCaseTest(int input, boolean shallFail) {
        this.input = input;
        this.shallFail = shallFail;
    }

    @Test
    public void testReverseThrowsExceptions() {
        Exception e = null;
        try {
            ReverseBinary.reverse(input);
        } catch (Exception exp) {
            e = exp;
        } finally {
            assertEquals(e instanceof IllegalArgumentException, shallFail);
        }
    }
}
