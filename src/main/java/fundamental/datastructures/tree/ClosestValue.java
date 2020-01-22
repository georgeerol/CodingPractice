package fundamental.datastructures.tree;

/**
 * Created by George Fouche on 1/18/20.
 */
public class ClosestValue {

    /**
     * Average Time: O(log(n)) | Average Space: O(log(n))
     * Worst Time : O(n) | O(n)
     *
     * @param tree
     * @param target
     * @return
     */
    public static int findClosestValueInBst(TreeNode tree, int target) {
        return findClosestValueInBst(tree, target, Double.MAX_VALUE);
    }

    private static int findClosestValueInBst(TreeNode tree, int target, double closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.getData())) {
            closest = tree.getData();
        }
        if (target < tree.getData() && tree.getLeftChild() != null)
            return findClosestValueInBst(tree.getLeftChild(), target, closest);
        else if (target > tree.getData() && tree.getRightChild() != null)
            return findClosestValueInBst(tree.getRightChild(), target, closest);
        else
            return (int) closest;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] sample = {10, 5, 15, 2, 1, 5, 15, 13, 22, 14};
        for (int i : sample) bst.insert(i);
        System.out.println(findClosestValueInBst(bst.getRoot(), 12));


    }
}
