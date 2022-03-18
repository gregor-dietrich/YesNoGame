package main;

public final class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(final int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        if (this.left == null) this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        if (this.right == null) this.right = right;
    }

    public String print() {
        return print("", true, "");
    }

    // third param ("sb") is useless?
    public String print(final String prefix, final boolean isTail, final String sb) {
        if (right != null) right.print(prefix + (isTail ? "|" : " ") + "   ", false, sb);
        System.out.println(prefix + (isTail ? "\\" : "/") + "-- " + data);
        if (left != null) left.print(prefix + (isTail ? " " : "|") + "   ", true, sb);
        return sb;
    }

    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) left.printPreOrder();
        if (right != null) right.printPreOrder();
    }

    public void printPostOrder() {
        if (left != null) left.printPostOrder();
        if (right != null) right.printPostOrder();
        System.out.print(data + " ");
    }

    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.print(data + " ");
        if (right != null) right.printInOrder();
    }
}
