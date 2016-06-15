package hr.fer.zemris.java.tecaj.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rectangle class calculates area and perimeter of a rectangle. You need to
 * enter width than height of a rectangle.
 * 
 * @author TheKarlo95
 * @version 1.0
 */
public class Rectangle {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command line arguments. You need to enter width than height of
     *            a rectangle.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public static void main(String[] args) throws IOException {
        double width = 0;
        double height = 0;
        double area = 0;
        double perimeter = 0;

        if (args.length == 2) {
            width = Double.parseDouble(args[0]);
            height = Double.parseDouble(args[1]);
        } else if (args.length == 0) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            width = inputParam(reader, "width");
            height = inputParam(reader, "height");
            reader.close();
        } else {
            System.out.println("Invalid number of arguments was provided.");
        }

        if (width != 0 || height != 0) {
            area = width * height;
            perimeter = 2 * (height + width);
            System.out.printf("You have specified a rectangle with width %.1f "
                    + "and height %.1f. Its area is %.1f and its perimeter is %.1f.", width, height, area, perimeter);
        }
    }

    /**
     * 
     * @param reader
     *            BuffereReader object used to read from standard input.
     * @param paramType
     *            Use "width" or "height". It defines wether you want to input
     *            height or width of a rectangle.
     * @return Returns number inputed trough standard input.
     * @throws IOException
     *             IOException Signals that an I/O exception of some sort has
     *             occurred.
     */
    private static double inputParam(BufferedReader reader, String paramType) throws IOException {
        double number = 0;

        while (true) {
            System.out.println("Please provide " + paramType.toLowerCase()
                    + ": ");
            String line = reader.readLine();

            if (line == null)
                break;

            line = line.trim();
            if (line.isEmpty()) {
                System.out.println("Nothing was given.");
                continue;
            }

            number = Double.parseDouble(line);
            if (number < 0)
                System.out.println(paramType.substring(0, 1).toUpperCase()
                        + paramType.substring(1) + " is negative.");
            else
                break;
        }

        return number;
    }
}
