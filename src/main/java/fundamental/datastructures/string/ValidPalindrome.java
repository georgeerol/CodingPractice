package fundamental.datastructures.string;

/**
 * Created by George Fouche on 1/28/20.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String str = "abcdcba";
        System.out.println(isPalindrome1(str));
        System.out.println(isPalindrome2(str));
        System.out.println(isPalindrome3(str));
    }


    /**
     * O(n) time | O(n) space
     * @param str
     * @return
     */
    public static boolean isPalindrome3(String str) {
        return isPalindrome3(str, 0);
    }

    public static boolean isPalindrome3(String str, int i) {
        int j = str.length() - 1 - i;
        return i >= j || str.charAt(i) == str.charAt(j) && isPalindrome3(str, i + 1);

    }

    /**
     * O(n) time | O(n) space
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }

    /**
     * O(n^2) | O(n) space
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome1(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);// re-create new string
        }
        return str.equals(reversedString);
    }
}
