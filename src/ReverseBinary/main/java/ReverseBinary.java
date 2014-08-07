import java.util.Arrays;

/**
 * Reversing the binary representation of a given number. The reverse and convert to binary implementation is done with no use of standard java libs
 */
public class ReverseBinary {
    public static final int UPPER_LIMIT = 1000000000;
    /**
     * Converts an integer number into a char array of bits
     * This implementation is a bit different, comparing to {@link java.lang.Integer#toString(int, int)} as it converts only to the binary representation
     */
    protected static char[] toBinary(int number) {
        char[] res = new char[32]; // int is 32-bit
        int index = res.length - 1;
        int mask = 1;
        do {
            if ((number & mask) == 0) {
                res[index--] = '0';
            } else {
                res[index--] = '1';
            }

            number >>>= 1;
        } while (number > 0);

        // return only significant bits, without leading 0s
        return Arrays.copyOfRange(res, index + 1, 32);
    }

    /**
     * Takes a given number, transforms it to a binary format, reverses a sequence of bites and returns this as a result.
     *
     * @throws java.lang.IllegalArgumentException if <code>number</code> <= 0 or > 1000000000
     */
    public static int reverse(int number) throws IllegalArgumentException {
        if (number <= 0 || number > UPPER_LIMIT) {
            throw new IllegalArgumentException("Input number shall be 1 <= N <= " + 1000000000 + ", but provided: " + number);
        }

        // init an array of binaries
        char[] binary = toBinary(number);

        // reverse
        int n = binary.length;
        int j = n / 2;
        for (int i = 0; i < j; i++) {
            char tmp = binary[n - j + i];
            binary[n - j + i] = binary[j - 1 - i];
            binary[j - 1 - i] = tmp;
        }

        return Integer.valueOf(new String(binary), 2);
    }
}