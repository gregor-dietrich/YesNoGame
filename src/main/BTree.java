package main;

public final class BTree {
    private Node root;
    private Node currentNode;

    public BTree() {
        root = null;
    }

    public BTree(final Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(final Node root) {
        this.root = root;
    }

    public void printPreOrder() {
        root.printPreOrder();
    }

    public void printPostOrder() {
        root.printPostOrder();
    }

    public void printInOrder() {
        root.printInOrder();
    }
}
