package game.BTree;

public class Node extends ABTreeObj {
    private String data;
    private Node left;
    private Node right;

    public Node(final String data) {
        setData(data);
        setLeft(null);
        setRight(null);
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
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

    @Override
    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) left.printPreOrder();
        if (right != null) right.printPreOrder();
    }

    @Override
    public void printPostOrder() {
        if (left != null) left.printPostOrder();
        if (right != null) right.printPostOrder();
        System.out.print(data + " ");
    }

    @Override
    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.print(data + " ");
        if (right != null) right.printInOrder();
    }

    @Override
    public void print() {
        print("", true);
    }

    private void print(final String prefix, final boolean isTail) {
        if (right != null) right.print(prefix + (isTail ? "|" : " ") + "   ", false);
        System.out.println(prefix + (isTail ? "\\" : "/") + "-- " + data);
        if (left != null) left.print(prefix + (isTail ? " " : "|") + "   ", true);
    }
}
