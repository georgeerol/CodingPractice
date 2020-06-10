package fundamental.datastructures.e.tree;


/**
 * Created by George Fouche on 12/10/19.
 */
public class BinarySearchTree {

    private TreeNode root;


    public void insert(int data) {
        if (root == null) this.root = new TreeNode(data);
        else root.insert(data);
    }

    public int smallest() {
        if (root != null) return root.smallest();
        return -1;
    }

    public int biggest() {
        if (root != null) return root.biggest();
        return -1;
    }

    public TreeNode find(int data) {
        if (root != null) return root.find(data);
        return null;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Soft delete
     *
     * @param data
     */
    public void delete(int data) {
        TreeNode toDel = find(data);
        toDel.delete();

    }

    public void inOrderTraversal() {
        if (root != null) root.traverseInOrder();
    }

    public void preOrderTraversal() {
        if (root != null) root.traversePreOrder();
    }

    public void postOrderTraversal() {
        if (root != null) root.traversePostOrder();
    }


    public static void main(String[] args) {
        int[] sample = {212, 580, 6, 7, 28, 84, 112, 434};
        BinarySearchTree bst = new BinarySearchTree();
        for (int x : sample) bst.insert(x);
        System.out.println("Smallest:");
        System.out.println(bst.smallest());
        System.out.println("Biggest:");
        System.out.println(bst.biggest());
        System.out.println("In Order Traversal");
        bst.inOrderTraversal();
        System.out.println("\nPre Order Traversal");
        bst.preOrderTraversal();
        System.out.println("\nPost Order Traversal");
        bst.postOrderTraversal();


    }

}
