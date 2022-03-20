package game;

public final class QuestionTree {
    private Question root;
    private Question currentQuestion;

    public QuestionTree() {
        this(null);
    }

    public QuestionTree(final Question root) {
        this.root = root;
    }

    public void print() {
        if (root != null) root.print();
        else System.out.println("Tree is empty.");
    }

    public Question getRoot() {
        return root;
    }

    public void setRoot(final Question root) {
        this.root = root;
    }

    public Question getCurrent() {
        return currentQuestion;
    }

    public void setCurrent(final Question current) {
        this.currentQuestion = current;
    }
}
