import java.util.Scanner;

/**
 * ShawarmaOrder program that calculates the total cost of a shawarma order
 * including type, filling, drink, and HST.
 */
public final class ShawarmaOrder {

    /** Price of a shawarma plate. */
    public static final float PLATE_PRICE = 12.0F;

    /** Price of a shawarma wrap. */
    public static final float WRAP_PRICE = 10.0F;

    /** Extra cost for meat filling. */
    public static final float MEAT_EXTRA = 2.0F;

    /** Price of a drink. */
    public static final float DRINK_PRICE = 3.0F;

    /** HST tax rate. */
    public static final float HST = 0.13F;

    /** Private constructor to prevent instantiation. */
    private ShawarmaOrder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Calculates cost based on shawarma type.
     *
     * @param type The type of shawarma (plate/wrap).
     * @return The cost of the selected type.
     */
    public static float getTypeCost(final String type) {
        if (type.equals("plate")) {
            return PLATE_PRICE; // Return price for plate
        } else {
            return WRAP_PRICE; // Return price for wrap
        }
    }

    /**
     * Calculates cost based on filling.
     *
     * @param filling The type of filling (meat/veg).
     * @return The cost of the filling.
     */
    public static float getFillingCost(final String filling) {
        if (filling.equals("meat")) {
            return MEAT_EXTRA; // Extra cost for meat
        } else {
            return 0.0F; // No extra cost for vegetables
        }
    }

    /**
     * Calculates cost based on drink choice.
     *
     * @param drink The drink choice (yes/no).
     * @return The cost of the drink.
     */
    public static float getDrinkCost(final String drink) {
        if (drink.equals("yes")) {
            return DRINK_PRICE; // Add drink price
        } else {
            return 0.0F; // No cost if no drink
        }
    }

    /**
     * Main method to run the ShawarmaOrder program.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        float total = 0.0F; // total of order

        System.out.println("Welcome to the Shawarma Shop!"); // Greeting message

        // Ask for shawarma type
        while (true) {
            System.out.println("Do you want a Shawarma plate or wrap?");
            System.out.print("(plate/wrap): ");
            String type = scanner.nextLine(); // Read user input

            if (type.equals("plate") || type.equals("wrap")) {
                total += getTypeCost(type); // Add price of chosen type
                break; // Exit loop if valid input
            } else {
                System.out.println("Invalid shawarma type. Please try again.");
                // Error message
            }
        }

        // Ask for filling
        while (true) {
            System.out.println("Do you want meat or vegetables? (meat/veg)");
            String filling = scanner.nextLine(); // Read input

            if (filling.equals("meat") || filling.equals("veg")) {
                total += getFillingCost(filling); // Add filling cost
                break; // Exit loop if valid input
            } else {
                System.out.println("Invalid filling choice. Please try again.");
                // Error message
            }
        }

        // Ask for drink
        while (true) {
            System.out.println("Do you want a drink? (yes/no)");
            String drink = scanner.nextLine(); // Read input

            if (drink.equals("yes") || drink.equals("no")) {
                total += getDrinkCost(drink); // Add drink cost
                break; // Exit loop if valid input
            } else {
                System.out.println("Invalid drink choice. Please try again.");
                // Error message
            }
        }

        // Calculate tax and total including HST
        float taxAmount = total * HST; // add HST
        float totalWithTax = total + taxAmount; // Add tax to total

        // Display final total and in two decimal places
        System.out.println("Your total including HST is: $");
        System.out.printf("%.2f%n", totalWithTax);

        scanner.close(); // Close scanner to prevent resource leak
    }
}
