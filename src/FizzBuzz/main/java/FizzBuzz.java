/**
 * Fizz Buzz impl
 */
public class FizzBuzz {

    /**
     * Returns a fizzbuzz-kinda string, where the multiples of three are replaced with "Fizz", the multiples of five
     * are replaced with "Buzz" and multiples of both three and five are replaced with "FizzBuzz"
     * @param n - the amount of elements to be printed, must be greater than 0
     * @return
     *
     * @throws IllegalArgumentException if n is smaller or equal to 0
     */
    public String printFizzBuzzNumbers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Positive 'n' is expected, but provided: " + n);
        }

        StringBuilder result = new StringBuilder(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.append("FizzBuzz").append(" ");
            } else if (i % 3 == 0) {
                result.append("Fizz").append(" ");
            } else if (i % 5 == 0) {
                result.append("Buzz").append(" ");
            } else {
                result.append(i).append(" ");
            }
        }

        // get rid of the trailing spaces if any
        int m = result.length() - 1;
        while (m > 0) {
            if (result.charAt(m) == ' ') {
                result = result.deleteCharAt(m);
                m--;
            } else {
                break;
            }
        }

        return result.toString();
    }

    public static void main(String... agrs) {
        FizzBuzz fizzBuzzer = new FizzBuzz();
        System.out.println(fizzBuzzer.printFizzBuzzNumbers(100));
    }
}
