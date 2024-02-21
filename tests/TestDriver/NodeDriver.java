package TestDriver;

import game.binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public final class NodeDriver extends ATestDriver {
    public static void main(String[] args) {
        // Root Node
        final BinaryTreeNode root = new BinaryTreeNode("1");
        // Child Nodes
        final List<BinaryTreeNode> nodes = new ArrayList<>();
        setChildren(root, nodes);
        // Test Printing
        printAll(root);
    }
}
