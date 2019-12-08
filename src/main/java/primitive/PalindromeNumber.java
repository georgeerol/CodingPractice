package primitive;

/**
 * https://leetcode.com/problems/palindrome-number/
 * Created by George Fouche on 12/8/19.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int num = 121;
        int num2 = 123;
        System.out.println(isPalindromeExp1(num));
        System.out.println(isPalindromeExp2(num));
        System.out.println(isPalindromeExp1(num2));
        System.out.println(isPalindromeExp2(num2));

    }

    private static boolean isPalindromeExp1(int num) {
        String stringNumber = new StringBuilder().append(num).toString();
        StringBuilder sb = new StringBuilder(stringNumber);
        String reverseString = sb.reverse().toString();
        return reverseString.equals(stringNumber);

    }

    /**
     * Time Complexity: O(n)
     * @param num
     * @return
     */
    private static boolean isPalindromeExp2(int num) {
        /**
         * A negative number can't be symmetric
         */
        if (num < 0) {
            return false;
        }

        /**
         *  10^b = x ... what is b? that is what log base 10 asks.
         *  'logarithmAnswer' is b
         */
        double logarithmAnswer = Math.log10(num);

        /**
         * 'logarithmAnswer' can be a float value. Like:
         * log10(99) = 1.99564 (meaning that 10^1.99564 =99)
         * so to get rid of the decimal part we floor it and then add 1
         */
        int totalDigits = (int) (Math.floor(logarithmAnswer)) + 1;

        /**
         * If x =999, we have 3 digits, so we want a mast the length of the integer.
         *
         * 100 = 10^2, so 10^(digits-1), we will use this later to extract and remove
         * the most significant digit
         */

        int mostSignificantExtractionMask = (int) Math.pow(10, totalDigits - 1);

        //Iterate half the total amount of digits, check both ends
        for (int i = 0; i < (totalDigits / 2); i++) {
            int mostSignificantDigit = num / mostSignificantExtractionMask;
            int onesPLaceDigit = num % 10;

            if (mostSignificantDigit != onesPLaceDigit) {
                return false;
            }

            // Removing most significant digit: 999 % 10 = 99
            num %= mostSignificantExtractionMask;

            /**
             * Removing the ones place digit: 99 / 10 = 9.9 => 9
             * (.9 truncated since this is not a float type, it is an integer)
             */
            num /= 10;

            // Remove 2 0's from the mask since we just lost 2 digits
            mostSignificantExtractionMask /= 100;
        }
        return true;

    }


}
