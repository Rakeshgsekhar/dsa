import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;

/**
 * Program to add two numbers represented as strings, handling large numbers
 * and enforcing comma formatting on both input and output.
 */
public class StringAdder {

    /**
     * Adds two number strings that may contain commas and returns the sum
     * formatted with commas.
     *
     * @param numStr1 The first number string (e.g., "1,234,567").
     * @param numStr2 The second number string (e.g., "987,654").
     * @return The sum formatted with commas, or an error message.
     */
    public static String addCommaFormattedStrings(String numStr1, String numStr2) {
        try {
            // 1. Clean the input strings by removing commas (Follow up 1)
            // This prepares the string for conversion to a BigInteger.
            String cleaned1 = numStr1.replaceAll(",", "");
            String cleaned2 = numStr2.replaceAll(",", "");

            // Basic validation: ensure the remaining string is only digits (0 or more)
            // and is not completely empty if we trim whitespace.
            if (!cleaned1.matches("\\d+") || !cleaned2.matches("\\d+")) {
                throw new IllegalArgumentException("Input strings must contain only digits and commas.");
            }

            // 2. Convert to BigInteger and perform addition
            BigInteger num1 = new BigInteger(cleaned1);
            BigInteger num2 = new BigInteger(cleaned2);
            BigInteger sum = num1.add(num2);

            // 3. Format the result with commas (Follow up 2)
            // NumberFormat is the standard, locale-aware way to format numbers.
            // Using Locale.US ensures the grouping separator is a comma.
            NumberFormat formatter = NumberFormat.getInstance(Locale.US);

            return formatter.format(sum);

        } catch (IllegalArgumentException e) {
            // Catch specific validation errors
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            // Catch other potential errors, like null inputs
            return "An unexpected error occurred during addition.";
        }
    }

    /**
     * Main method for demonstration.
     */
    public static void main(String[] args) {
        // Test case 1: Standard large numbers with input commas
        String n1 = "1,234,567,890,123";
        String n2 = "9,876,543,210,987";
        String result1 = addCommaFormattedStrings(n1, n2);

        System.out.println("--- Test Case 1 (Large Numbers) ---");
        System.out.println("Num 1: " + n1);
        System.out.println("Num 2: " + n2);
        System.out.println("Sum:   " + result1);
        // Expected sum: 11,111,111,101,110

        System.out.println("\n-----------------------------------");

        // Test case 2: Numbers without input commas
        String n3 = "123456789";
        String n4 = "987654321";
        String result2 = addCommaFormattedStrings(n3, n4);

        System.out.println("--- Test Case 2 (No Input Commas) ---");
        System.out.println("Num 1: " + n3);
        System.out.println("Num 2: " + n4);
        System.out.println("Sum:   " + result2);
        // Expected sum: 1,111,111,110

        System.out.println("\n-----------------------------------");

        // Test case 3: Error handling (invalid characters)
        String n5 = "123A456";
        String n6 = "789";
        String result3 = addCommaFormattedStrings(n5, n6);

        System.out.println("--- Test Case 3 (Invalid Input) ---");
        System.out.println("Num 1: " + n5);
        System.out.println("Num 2: " + n6);
        System.out.println("Result: " + result3);
    }
}