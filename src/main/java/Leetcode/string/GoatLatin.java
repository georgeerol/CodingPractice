package Leetcode.string;

import java.util.HashSet;

/**
 * leetcode: https://leetcode.com/problems/goat-latin/
 * Created by George Fouche on 12/18/19.
 */
public class GoatLatin {


    public static void main(String[] args) {

        /**
         * 1. If a word begins with a vowel(a,e,i,0,u) append "ma" to the end of the word. Word 'apple' => 'applema'
         * 2. If a word consonant remove the first letter and append it to the end, then add "ma". Word 'goat' => 'oatgma'
         * 3. add 'a'  to the end of each word per its word index in the entence starting with 1.
         *
         */
        String S = "I speak Goat Latin";
        System.out.println(toGoatLatin(S));
        System.out.println("Imaa peaksmaaa oatGmaaaa atinLmaaaaa");

    }

    private static String toGoatLatin(String S) {

        HashSet<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray())
            vowels.add(c);


        StringBuilder result = new StringBuilder();
        int index = 1;
        for (String word : S.split(" ")) {
            if (index > 1) {
                result.append(" ");
            }
            char fist_letter = word.charAt(0);
            if (vowels.contains(fist_letter)) {
                result.append(word).append("ma");
            } else {
                result.append(word.substring(1)).append(fist_letter).append("ma");
            }

            for (int j = 0; j < index; j++) {
                result.append('a');
            }

            index += 1;
        }
        return result.toString();
    }

}
