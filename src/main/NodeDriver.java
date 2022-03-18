package main;

import java.util.ArrayList;

public class NodeDriver {
    public static void main(String[] args) {
        // Nodes Array
        final var nodes = new ArrayList<Node>();
        // Root Node
        var root = new Node(1);
        nodes.add(root);
        // Child Nodes
        for (int i = 2; i < 8; i++) nodes.add(new Node(i));

        // Set Children in Parents
        nodes.get(0).setLeft(nodes.get(1));
        nodes.get(0).setRight(nodes.get(2));
        nodes.get(1).setLeft(nodes.get(3));
        nodes.get(1).setRight(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));
        nodes.get(4).setLeft(nodes.get(6));

        // Test Printing Methods
        root.printPreOrder();
        System.out.println();
        root.printPostOrder();
        System.out.println();
        root.printInOrder();
        System.out.println();
        root.print();
    }
}
