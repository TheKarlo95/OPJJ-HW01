package hr.fer.zemris.java.tecaj.hw1;

/**
 * Command line program which decompose a number into prime factors. You need to
 * enter Number which you want to decompose.
 * 
 * @author TheKarlo95
 * @version 1.0
 */
public class NumberDecomposition {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command line argument.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.printf("Error: Invalid number of arguments!\n");
            return;
        }

        int num = Integer.parseInt(args[0]);

        if (num < 2) {
            System.err.printf("Error: Invalid argument!\n");
            return;
        }

        // Decomposing the number and displaying the primes
        int count = 1;
        System.out.printf("You requested decomposition of number %d onto prime"
                + " factors. Here they are:\n", num);

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.printf("%d) %d\n", count, i);
                num /= i;
                count++;
                i--;
            }
        }
    }
}
