package hr.fer.zemris.java.tecaj.hw1;

import java.text.DecimalFormat;

/**
 * Roots class calculates root of a complex number. You need to write real and
 * imaginary part of a complex number in command line.
 * 
 * @author TheKarlo95
 * @version 1.0
 */
public class Roots {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command line arguments.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Error: Only 3 arguments allowed.");
            return;
        }

        double real = Integer.parseInt(args[0].trim());
        double imaginary = Integer.parseInt(args[1].trim());
        int root = Integer.parseInt(args[2].trim());

        if (root < 1) {
            System.err.println("Error: Third argument must be 1 or bigger.");
            return;
        }

        root(real, imaginary, root);
    }

    /**
     * Calculating n-th root of an imaginary number.
     * 
     * @param real
     *            Real part of complex number.
     * @param imaginary
     *            Imaginary part of complex number
     * @param n
     *            Number of the root which needs to be calculated.
     */
    public static void root(double real, double imaginary, double n) {
        double radius = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
        double angle = Math.atan2(imaginary, real);

        for (int i = 0; i < n; i++) {
            double re = Math.pow(radius, 1 / n)
                    * Math.cos((angle + i * 2.0 * Math.PI) / n);
            double im = Math.pow(radius, 1 / n)
                    * Math.sin((angle + i * 2.0 * Math.PI) / n);

            System.out.println(complexToString(re, im));
        }
    }

    /**
     * Formats complex number.
     * 
     * @param real
     *            Real part of complex number.
     * @param imaginary
     *            Imaginary part of complex number.
     * @return Formated string
     */
    public static String complexToString(double real, double imaginary) {
        DecimalFormat format = new DecimalFormat("#.##");
        format.setDecimalSeparatorAlwaysShown(false);
        if (real == 0)
            return String.format("%si", format.format(imaginary));
        else if (imaginary > 0)
            return String.format("%s + %si", format.format(real), format.format(imaginary));
        else if (imaginary < 0)
            return String.format("%s - %si", format.format(real), format.format(Math.abs(imaginary)));
        else if (imaginary == 0)
            return String.format("%s", format.format(real));

        return null;
    }

}
