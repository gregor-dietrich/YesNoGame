package game.gameTree;

import game.binaryTree.BinaryTreeNode;

public final class GameTreeNode extends BinaryTreeNode {
    private static final long serialVersionUID = 1L;

    private boolean isAnimal;

    public GameTreeNode(final String data) {
        super(data);
        this.isAnimal = false;
    }

    public GameTreeNode getYesNode() {
        return (GameTreeNode) getRight();
    }

    public void setYesNode(final GameTreeNode yesNode) {
        setRight(yesNode);
    }

    public GameTreeNode getNoNode() {
        return (GameTreeNode) getLeft();
    }

    public void setNoNode(final GameTreeNode noNode) {
        setLeft(noNode);
    }

    public boolean isAnimal() {
        return isAnimal;
    }

    public void setAnimal(final boolean isAnimal) {
        this.isAnimal = isAnimal;
    }
}
