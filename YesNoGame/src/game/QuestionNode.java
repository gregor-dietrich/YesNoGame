package game;

import java.io.Serializable;
import java.util.Locale;

public final class QuestionNode implements Serializable {
    private String data;
    private QuestionNode yesNode;
    private QuestionNode noNode;
    private boolean animal;

    public QuestionNode(final String data) {
        this.data = data;
        this.yesNode = null;
        this.noNode = null;
        this.animal = false;
    }

    public void print() {
        print("", true);
    }

    private void print(final String prefix, final boolean isTail) {
        if (yesNode != null) yesNode.print(prefix + (isTail ? "|" : " ") + "   ", false);
        System.out.println(prefix + (isTail ? "\\" : "/") + "-- " + getData());
        if (noNode != null) noNode.print(prefix + (isTail ? " " : "|") + "   ", true);
    }

    public String getData() {
        return data.substring(0, 1).toUpperCase(Locale.ROOT) + data.substring(1);
    }

    public void setData(final String data) {
        this.data = data;
    }

    public QuestionNode getYesNode() {
        return yesNode;
    }

    public void setYesNode(final QuestionNode yesNode) {
        if (this.yesNode == null) this.yesNode = yesNode;
    }

    public QuestionNode getNoNode() {
        return noNode;
    }

    public void setNoNode(final QuestionNode noNode) {
        if (this.noNode == null) this.noNode = noNode;
    }

    public boolean isAnimal() {
        return animal;
    }

    public void setAnimal(final boolean animal) {
        this.animal = animal;
    }
}
