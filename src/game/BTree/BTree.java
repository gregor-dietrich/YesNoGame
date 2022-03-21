package game.BTree;

import java.util.Objects;

public class BTree extends ABTreeObj {
    private Node root;
    private Node currentNode;

    public BTree() {
        this(null);
    }

    public BTree(final Node root) {
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
        if (root != null) root.print();
        else System.out.println("Tree is empty.");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(final Node node) {
        if (node == null) return 0;
        int count = 1;
        count += countNodes(node.getLeft());
        count += countNodes(node.getRight());
        return count;
    }

    public boolean search(final String data) {
        return search(root, data);
    }

    private boolean search(final Node node, final String data) {
        if (Objects.equals(node.getData(), data)) return true;
        if (node.getLeft() != null) if (search(node.getLeft(), data)) return true;
        if (node.getRight() != null) return search(node.getRight(), data);
        return false;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(final Node root) {
        this.root = root;
    }

    public Node getCurrent() {
        return currentNode;
    }

    public void setCurrent(final Node current) {
        this.currentNode = current;
    }
}
