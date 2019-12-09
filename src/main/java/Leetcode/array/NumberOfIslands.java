package Leetcode.array;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Created by George Fouche on 12/8/19.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        int[][] arr2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1}};


        System.out.println(numOfIslands(arr));
        System.out.println(numOfIslands(arr2));
    }


    private static int numOfIslands(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void callBFS(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return;


        grid[i][j] = 0;
        callBFS(grid, i + 1, j); // up
        callBFS(grid, i - 1, j);// down
        callBFS(grid, i, j - 1);// left
        callBFS(grid, i, j + 1);// right

    }
}
