package TestDriver;

import game.BTree.Node;

import java.util.ArrayList;
import java.util.List;

public final class NodeDriver extends ATestDriver {
    public static void main(String[] args) {
        // Root Node
        final Node root = new Node("1");
        // Child Nodes
        final List<Node> nodes = new ArrayList<>();
        setChildren(root, nodes);
        // Test Printing
        printAll(root);
    }
}
