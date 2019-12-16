package fundamental.datastructures.tree;

/**
 * Created by George Fouche on 12/14/19.
 */
public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private boolean isDeleted = false;


    TreeNode(int data) {
        this.data = data;
    }

    TreeNode find(int data) {
        if (this.data == data && !isDeleted()) return this;
        if (data < this.data && leftChild != null) return leftChild.find(data);
        if (rightChild != null) return rightChild.find(data);
        return null;
    }

    void insert(int data) {
        if (data >= this.data) {
            //right child
            if (this.rightChild == null) this.rightChild = new TreeNode(data);
            else this.rightChild.insert(data);
        } else {
            // left child
            if (this.leftChild == null) this.leftChild = new TreeNode(data);
            else this.leftChild.insert(data);
        }
    }

    int smallest() {
        if (this.leftChild == null) return this.data;
        return this.leftChild.smallest();
    }

    int biggest() {
        if (this.rightChild == null) return this.data;
        return this.rightChild.biggest();
    }


    private boolean isDeleted() {
        return isDeleted;
    }

    void delete() {
        isDeleted = true;
    }

    void traverseInOrder() {
        if (this.leftChild != null) this.leftChild.traverseInOrder();
        System.out.print(data + " ");
        if (this.rightChild != null) this.rightChild.traverseInOrder();
    }

    void traversePreOrder() {
        System.out.print(data + " ");
        if (this.leftChild != null) this.leftChild.traversePreOrder();
        if (this.rightChild != null) this.rightChild.traversePreOrder();
    }


    void traversePostOrder() {
        if (this.leftChild != null) this.leftChild.traversePostOrder();
        if (this.rightChild != null) this.rightChild.traversePostOrder();
        System.out.print(data + " ");
    }

}
