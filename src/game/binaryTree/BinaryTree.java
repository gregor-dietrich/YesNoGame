package game.binaryTree;

import java.util.Objects;

public class BinaryTree extends ABinaryTreeObj {
    private static final long serialVersionUID = 1L;

    private BinaryTreeNode root;
    private BinaryTreeNode currentBinaryTreeNode;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(final BinaryTreeNode root) {
        setRoot(root);
    }

    @Override
    public void printPreOrder() {
        root.printPreOrder();
    }

    @Override
    public void printPostOrder() {
        root.printPostOrder();
    }

    @Override
    public void printInOrder() {
        root.printInOrder();
    }

    @Override
    public void print() {
        if (root != null)
            root.print();
        else System.out.println("Tree is empty.");
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(final BinaryTreeNode node) {
        if (node == null) return 0;
        int count = 1;
        count += countNodes(node.getLeft());
        count += countNodes(node.getRight());
        return count;
    }

    public boolean search(final String data) {
        return search(root, data);
    }

    private boolean search(final BinaryTreeNode node, final String data) {
        if (node == null)
            return false;
        if (Objects.equals(node.getData(), data))
            return true;
        return search(node.getLeft(), data) || search(node.getRight(), data);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(final BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getCurrent() {
        return currentBinaryTreeNode;
    }

    public void setCurrent(final BinaryTreeNode current) {
        this.currentBinaryTreeNode = current;
    }
}
