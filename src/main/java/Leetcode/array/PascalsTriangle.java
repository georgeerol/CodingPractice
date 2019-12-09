package Leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * Created by George Fouche on 12/8/19.
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println( generate(numRows));
    }

    private static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;


        int row = 1;
        List<Integer> first_row = new ArrayList<>();
        first_row.add(row);
        triangle.add(first_row);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> current_row = new ArrayList<>();

            current_row.add(row);

            for (int j = 1; j < i; j++) {
                current_row.add(prev_row.get(j - 1) + prev_row.get(j));
            }
            current_row.add(row);
            triangle.add(current_row);
        }
        return triangle;
    }

}
