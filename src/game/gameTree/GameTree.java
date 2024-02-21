package game.gameTree;

import game.binaryTree.BinaryTree;

public final class GameTree extends BinaryTree {
    private static final long serialVersionUID = 1L;

    public GameTree() {
        this(null);
    }

    public GameTree(final GameTreeNode root) {
        super(root);
    }

    public int countAnimals() {
        return countAnimals((GameTreeNode) getRoot());
    }

    private int countAnimals(final GameTreeNode node) {
        if (node == null) return 0;
        int count = node.isAnimal() ? 1 : 0;
        count += countAnimals(node.getYesNode());
        count += countAnimals(node.getNoNode());
        return count;
    }

    @Override
    public GameTreeNode getCurrent() {
        return (GameTreeNode) super.getCurrent();
    }
}
