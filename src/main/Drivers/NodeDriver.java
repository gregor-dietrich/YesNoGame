package main.Drivers;

import main.BTree.Node;

import java.util.ArrayList;

public final class NodeDriver extends ADriver {
    public static void main(String[] args) {
        // Root Node
        final var root = new Node(1);
        // Child Nodes
        final var nodes = new ArrayList<Node>();
        setChildren(root, nodes);
        // Test Printing
        System.out.println("PreOrder:");
        root.printPreOrder();
        System.out.println("\nPostOrder:");
        root.printPostOrder();
        System.out.println("\nInOrder:");
        root.printInOrder();
        System.out.println("\nTree Diagram:");
        root.print();
    }
}
