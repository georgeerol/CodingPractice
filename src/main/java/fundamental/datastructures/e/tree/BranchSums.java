package fundamental.datastructures.e.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George Fouche on 1/19/20.
 */
public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;


        BinaryTree(int value) {
            this.value = value;
        }


    }

    private static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    private static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null) return;

        int newRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }

    public static void main(String[] args) {
        /**
         *              1
         *             / \
         *            2   3
         *           / \ /\
         *          4  56 7
         *         /\  \
         *        8 9  10
         *
         */
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);

        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);

        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right.right = new BinaryTree(10);

        List<Integer> dfd = branchSums(tree);
        System.out.println(Arrays.toString(dfd.toArray()));


    }


}
