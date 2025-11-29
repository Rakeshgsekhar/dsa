import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;

/**
 * Program to add two numbers represented as strings, handling large numbers
 * and enforcing comma formatting on both input and output.
 * * Implements the addition using a manual string/array-based approach.
 */
public class StringAdder2 {

    /**
     * Adds two number strings that may contain commas and returns the sum
     * formatted with commas. The addition is performed manually, digit by digit.
     *
     * @param numStr1 The first number string (e.g., "1,234,567").
     * @param numStr2 The second number string (e.g., "987,654").
     * @return The sum formatted with commas, or an error message.
     */
    public static String addCommaFormattedStrings(String numStr1, String numStr2) {
        try {
            /***++
             // 1. Clean the input strings by removing commas (Follow up 1)
             String cleaned1 = numStr1.replaceAll(",", "");
             String cleaned2 = numStr2.replaceAll(",", "");

             // Basic validation: ensure the remaining string is only digits
             if (!cleaned1.matches("\\d+") || !cleaned2.matches("\\d+")) {
             throw new IllegalArgumentException("Input strings must contain only digits and commas.");
             }

             // --- Optimized Backward Iteration Logic ---

             // Pointers start at the last character (least significant digit)
             int i = cleaned1.length() - 1;
             int j = cleaned2.length() - 1;
             int carry = 0;

             // We use a StringBuilder to build the result in reverse order (LSD first)
             StringBuilder resultReversed = new StringBuilder();

             // Loop continues as long as there are digits in either number or a final carry exists
             while (i >= 0 || j >= 0 || carry > 0) {

             // Get digit from string 1, decrement pointer (i--), or use 0 if out of bounds
             int digit1 = i >= 0 ? Character.getNumericValue(cleaned1.charAt(i--)) : 0;

             // Get digit from string 2, decrement pointer (j--), or use 0 if out of bounds
             int digit2 = j >= 0 ? Character.getNumericValue(cleaned2.charAt(j--)) : 0;

             int sum = digit1 + digit2 + carry;

             // Append the last digit of the sum
             resultReversed.append(sum % 10);

             // Calculate the new carry for the next iteration
             carry = sum / 10;
             }

             // Reverse the final result back to the correct order (MSD first)
             String sumStr = resultReversed.reverse().toString();

             // Handle case where input resulted in "0"
             if (sumStr.isEmpty()) {
             sumStr = "0";
             }

             // 3. Manually format the result with commas (Follow up 2)
             return manualCommaFormatter(sumStr);
             */

            // 1. Clean the input strings by removing commas (Follow up 1)
            String cleaned1 = numStr1.replaceAll(",", "");
            String cleaned2 = numStr2.replaceAll(",", "");

            // Basic validation: ensure the remaining string is only digits
            if (!cleaned1.matches("\\d+") || !cleaned2.matches("\\d+")) {
                throw new IllegalArgumentException("Input strings must contain only digits and commas.");
            }

            // --- Array/Manual Addition Logic ---

            // Reverse strings for easier right-to-left (least significant digit first) addition
            String reversed1 = new StringBuilder(cleaned1).reverse().toString();
            String reversed2 = new StringBuilder(cleaned2).reverse().toString();

            int len1 = reversed1.length();
            int len2 = reversed2.length();
            int maxLength = Math.max(len1, len2);

            StringBuilder resultReversed = new StringBuilder();
            int carry = 0;

            for (int i = 0; i < maxLength; i++) {
                // Get digit 1 (or 0 if index is out of bounds for the shorter number)
                int digit1 = i < len1 ? Character.getNumericValue(reversed1.charAt(i)) : 0;
                // Get digit 2 (or 0 if index is out of bounds for the shorter number)
                int digit2 = i < len2 ? Character.getNumericValue(reversed2.charAt(i)) : 0;

                int sum = digit1 + digit2 + carry;

                // Append the last digit of the sum to the result
                resultReversed.append(sum % 10);

                // Calculate the new carry
                carry = sum / 10;
            }

            // Handle the final carry if it's non-zero
            if (carry != 0) {
                resultReversed.append(carry);
            }

            // Reverse the final result back to the correct order
            String sumStr = resultReversed.reverse().toString();

            // Handle case where input was "0" + "0" resulting in an empty string (or just "0")
            if (sumStr.isEmpty()) {
                sumStr = "0";
            }

            // 3. Manually format the result with commas (Follow up 2)
            return manualCommaFormatter(sumStr);

        } catch (IllegalArgumentException e) {
            // Catch specific validation errors
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            // Catch other potential errors
            return "An unexpected error occurred: " + e.getMessage();
        }
    }

    /**
     * Helper function to insert commas every three digits into a numeric string, 
     * working from right to left.
     *
     * @param sumStr The unformatted sum string (e.g., "1234567890").
     * @return The formatted string (e.g., "1,234,567,890").
     */
    private static String manualCommaFormatter(String sumStr) {
        // We iterate from the end, inserting a comma every three digits.
        StringBuilder formatted = new StringBuilder(sumStr);
        int length = formatted.length();

        // Start inserting commas from the end (index > 0)
        for (int i = length - 3; i > 0; i -= 3) {
            formatted.insert(i, ',');
        }

        return formatted.toString();
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

        // Test case 2: Numbers without input commas (testing manual comma formatting)
        String n3 = "123456789";
        String n4 = "987654321";
        String result2 = addCommaFormattedStrings(n3, n4);

        System.out.println("--- Test Case 2 (No Input Commas) ---");
        System.out.println("Num 1: " + n3);
        System.out.println("Num 2: " + n4);
        System.out.println("Sum:   " + result2);
        // Expected sum: 1,111,111,110

        System.out.println("\n-----------------------------------");

        // Test case 3: Numbers with different lengths and carries
        String n5 = "999";
        String n6 = "1";
        String result3 = addCommaFormattedStrings(n5, n6);

        System.out.println("--- Test Case 3 (Carry over, different lengths) ---");
        System.out.println("Num 1: " + n5);
        System.out.println("Num 2: " + n6);
        System.out.println("Sum:   " + result3);
        // Expected sum: 1,000

        System.out.println("\n-----------------------------------");

        // Test case 4: Error handling (invalid characters)
        String n7 = "123A456";
        String n8 = "789";
        String result4 = addCommaFormattedStrings(n7, n8);

        System.out.println("--- Test Case 4 (Invalid Input) ---");
        System.out.println("Num 1: " + n7);
        System.out.println("Num 2: " + n8);
        System.out.println("Result: " + result4);
    }
}