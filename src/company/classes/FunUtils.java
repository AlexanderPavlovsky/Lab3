package company.classes;

import java.util.Scanner;

/**
 * Class function utils
 */
public class FunUtils {
    /**
     * Is this number positive?
     *
     * @param str Input data
     * @return This number is positive
     */
    public static int isPositive(final Scanner str) {
        int positive = isInt(str);
        while (positive < 0) {
            System.out.println("That not a positive number");
            positive = isInt(str);
        }
        return positive;
    }

    /**
     * Is this number int?
     *
     * @param str Input data
     * @return This number is int
     */
    private static int isInt(final Scanner str) {
        while (!str.hasNextInt()) {
            System.out.println("That not a number!");
            str.next();
        }
        return str.nextInt();
    }

    /**
     * Is this number flight?
     *
     * @param str Input data
     * @return This is number flight
     */
    public static String isNumberFlight(final Scanner str) {
        String line = str.next();
        while (!line.matches("(([A-Z]{2}|[A-Z][0-9])-[0-9]{3,5})")) {
            System.out.println("That not a number flight! Example: S7-206, EK-7892");
            line = str.next();
        }
        return line;
    }

    /**
     * Is this number baggage?
     *
     * @param str Input data
     * @return This is number baggage
     */
    public static String isNumberBaggage(final Scanner str) {
        String line = str.next();
        while (!line.matches("([A-Z][0-9]{7})")) {
            System.out.println("That not a number baggage! Example: S5896234, F1523465");
            line = str.next();
        }
        return line;
    }
}
