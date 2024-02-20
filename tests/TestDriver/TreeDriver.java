package TestDriver;

import game.BTree.BTree;
import game.BTree.Node;

import java.util.ArrayList;
import java.util.List;

public final class TreeDriver extends ATestDriver {
    public static void main(String[] args) {
        // Tree
        final BTree tree = new BTree();
        System.out.println("Nodes in (empty) tree: " + tree.countNodes());
        // Root Node
        final Node root = new Node("1");
        tree.setRoot(root);
        System.out.println("Nodes in tree (after adding root): " + tree.countNodes());
        // Child Nodes
        final List<Node> nodes = new ArrayList<>();
        setChildren(root, nodes);
        System.out.println("Nodes in tree (after adding children): " + tree.countNodes());
        // Set root as current
        tree.setCurrent(tree.getRoot());
        System.out.println("Current Node: " + tree.getCurrent().getData());
        // Test Printing
        printAll(root);
    }
}
