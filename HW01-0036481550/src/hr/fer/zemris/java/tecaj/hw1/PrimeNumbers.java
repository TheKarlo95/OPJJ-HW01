package hr.fer.zemris.java.tecaj.hw1;

/**
 * PrimeNumbers class generates the first n prime numbers and displays it in
 * console. You need to enter number of prime numbers to be generated.
 * 
 * @author TheKarlo95
 * @version 1.0
 */
public class PrimeNumbers {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command line argument. You need to enter number of prime
     *            numbers to be generated.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Only 1 argument allowed.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int number = 2;
        int count = 1;

        while (n > 0) {
            if (isPrime(number)) {
                System.out.println(count + ". " + number);
                count++;
                n--;
            }
            number++;
        }
    }

    /**
     * Provjerava da li je zadani broj prost broj.
     * 
     * @param number
     *            Broj koji zelimo provjeriti.
     * @return true ako je broj prost i false ako nije.
     */
    private static boolean isPrime(int number) {
        if (number % 2 == 0 && number != 2)
            return false;

        for (int i = 3; i * i <= number; i += 2)
            if (number % i == 0)
                return false;

        return true;
    }

}
