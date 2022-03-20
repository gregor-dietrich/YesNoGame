package main.Drivers;

import main.BTree.Node;

import java.util.ArrayList;

public abstract class ADriver {
    protected static void setChildren(final Node root, final ArrayList<Node> nodes) {
        nodes.add(root);
        for (int i = 2; i < 8; i++) nodes.add(new Node(i));
        root.setLeft(nodes.get(1));
        root.setRight(nodes.get(2));
        nodes.get(1).setLeft(nodes.get(3));
        nodes.get(1).setRight(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));
        nodes.get(4).setLeft(nodes.get(6));
    }
}
