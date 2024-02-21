package TestDriver;

import game.binaryTree.BinaryTree;
import game.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public final class TreeDriver extends ATestDriver {
    public static void main(String[] args) {
        // Tree
        final BinaryTree tree = new BinaryTree();
        System.out.println("Nodes in (empty) tree: " + tree.countNodes());
        // Root Node
        final BinaryTreeNode root = new BinaryTreeNode("1");
        tree.setRoot(root);
        System.out.println("Nodes in tree (after adding root): " + tree.countNodes());
        // Child Nodes
        final List<BinaryTreeNode> nodes = new ArrayList<>();
        setChildren(root, nodes);
        System.out.println("Nodes in tree (after adding children): " + tree.countNodes());
        // Set root as current
        tree.setCurrent(tree.getRoot());
        System.out.println("Current Node: " + tree.getCurrent().getData());
        // Test Printing
        printAll(root);
    }
}
