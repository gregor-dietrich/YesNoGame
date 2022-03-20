package game;

import java.io.Serializable;

public final class QuestionTree implements Serializable {
    private QuestionNode root;
    private QuestionNode currentQuestion;

    public QuestionTree() {
        this(null);
    }

    public QuestionTree(final QuestionNode root) {
        this.root = root;
    }

    public int countAnimals() {
        return countAnimals(root);
    }

    private int countAnimals(final QuestionNode node) {
        if (node == null) return 0;
        int count = node.isAnimal() ?  1 : 0;
        count += countAnimals(node.getYesNode());
        count += countAnimals(node.getNoNode());
        return count;
    }

    public void print() {
        if (root != null) root.print();
        else System.out.println("Tree is empty.");
    }

    public QuestionNode getRoot() {
        return root;
    }

    public void setRoot(final QuestionNode root) {
        this.root = root;
    }

    public QuestionNode getCurrent() {
        return currentQuestion;
    }

    public void setCurrent(final QuestionNode current) {
        this.currentQuestion = current;
    }
}
