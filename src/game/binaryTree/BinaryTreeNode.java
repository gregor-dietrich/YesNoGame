package game.binaryTree;

public class BinaryTreeNode extends ABinaryTreeObj {
    private static final long serialVersionUID = 1L;

    private String data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(final String data) {
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

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(final BinaryTreeNode left) {
        if (this.left == null) this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(final BinaryTreeNode right) {
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
