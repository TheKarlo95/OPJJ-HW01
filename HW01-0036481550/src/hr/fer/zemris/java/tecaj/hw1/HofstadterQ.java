package hr.fer.zemris.java.tecaj.hw1;

/**
 * HofstadterQ class generates the first n elements of Hofstadter's Q-sequence
 * and displays it in console. You need to enter number of Hofstadter's
 * Q-sequence to be generated.
 * 
 * @author TheKarlo95
 * @version 1.0
 */
public class HofstadterQ {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command line argument.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Only 1 argument allowed.");
            return;
        }

        long num = Long.parseLong(args[0]);
        if (num < 1) {
            System.out.println("Only numbers bigger or equal to 1 allowed.");
            return;
        }

        System.out.printf("You requested calculation of %d. number "
                + "of Hofstadter's Q-sequence. The requestednumber is %d.%n", num, getQ(num));
    }

    /**
     * Recursively calculates the n-th element of Hofstadter's Q-sequence.
     * 
     * @param n
     *            Ordinal number of Hofstadter's Q-sequence.
     * @return Number of Hofstadter's Q-sequence.
     */
    public static long getQ(long n) {
        return (n <= 2) ? 1L : getQ(n - getQ(n - 1)) + getQ(n - getQ(n - 2));
    }

}
