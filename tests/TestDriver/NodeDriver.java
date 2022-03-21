package TestDriver;

import game.BTree.Node;

import java.util.ArrayList;

public final class NodeDriver extends ATestDriver {
    public static void main(String[] args) {
        // Root Node
        final var root = new Node("1");
        // Child Nodes
        final var nodes = new ArrayList<Node>();
        setChildren(root, nodes);
        // Test Printing
        printAll(root);
    }
}
