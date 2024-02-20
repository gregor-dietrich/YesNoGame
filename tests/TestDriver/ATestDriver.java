package TestDriver;

import game.BTree.ABTreeObj;
import game.BTree.Node;

import java.util.List;

public abstract class ATestDriver {
    protected static void setChildren(final Node root, final List<Node> nodes) {
        nodes.add(root);
        for (int i = 2; i < 8; i++) nodes.add(new Node(String.valueOf(i)));
        root.setLeft(nodes.get(1));
        root.setRight(nodes.get(2));
        nodes.get(1).setLeft(nodes.get(3));
        nodes.get(1).setRight(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));
        nodes.get(4).setLeft(nodes.get(6));
    }

    protected static void printAll(final ABTreeObj root) {
        System.out.println("PreOrder:");
        root.printPreOrder();
        System.out.println("\nPostOrder:");
        root.printPostOrder();
        System.out.println("\nInOrder:");
        root.printInOrder();
        System.out.println("\nTree Diagram:");
        root.print();
        System.out.println();
    }
}
