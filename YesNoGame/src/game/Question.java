package game;

public final class Question {
    private String data;
    private Question yes;
    private Question no;

    public Question(final String data) {
        this.data = data;
        this.yes = null;
        this.no = null;
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
}
