package game.binaryTree;

import java.io.Serializable;

public abstract class ABinaryTreeObj implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract void printPreOrder();

    public abstract void printPostOrder();

    public abstract void printInOrder();

    public abstract void print();
}
