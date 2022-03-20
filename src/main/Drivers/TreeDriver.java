package main.Drivers;

import main.BTree.BTree;
import main.BTree.Node;

import java.util.ArrayList;

public final class TreeDriver extends ADriver {
    public static void main(String[] args) {
        // Tree
        final var tree = new BTree();
        System.out.println("Nodes in (empty) tree: " + tree.countNodes());
        // Root Node
        final var root = new Node(1);
        tree.setRoot(root);
        System.out.println("Nodes in tree (after adding root): " + tree.countNodes());
        // Child Nodes
        final var nodes = new ArrayList<Node>();
        setChildren(root, nodes);
        System.out.println("Nodes in tree (after adding children): " + tree.countNodes());
        // Set root as current
        tree.setCurrent(tree.getRoot());
        System.out.println("Current Node: " + tree.getCurrent().getData());
        // Test Printing
        System.out.println("PreOrder:");
        tree.printPreOrder();
        System.out.println("\nPostOrder:");
        tree.printPostOrder();
        System.out.println("\nInOrder:");
        tree.printInOrder();
        System.out.println("\nTree Diagram:");
        tree.print();
        System.out.println();
    }
}
