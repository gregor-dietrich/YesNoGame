package game;

public final class Question {
    private String data;
    private Question yes;
    private Question no;
    private boolean animal;

    public Question(final String data) {
        this.data = data;
        this.yes = null;
        this.no = null;
        this.animal = false;
    }

    public void print() {
        print("", true);
    }

    private void print(final String prefix, final boolean isTail) {
        if (yes != null) yes.print(prefix + (isTail ? "|" : " ") + "   ", false);
        System.out.println(prefix + (isTail ? "\\" : "/") + "-- " + data);
        if (no != null) no.print(prefix + (isTail ? " " : "|") + "   ", true);
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public Question getYes() {
        return yes;
    }

    public void setYes(final Question yes) {
        if (this.yes == null) this.yes = yes;
    }

    public Question getNo() {
        return no;
    }

    public void setNo(final Question no) {
        if (this.no == null) this.no = no;
    }

    public boolean isAnimal() {
        return animal;
    }

    public void setAnimal(final boolean animal) {
        this.animal = animal;
    }
}
