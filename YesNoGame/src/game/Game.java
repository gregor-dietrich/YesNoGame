package game;

import java.io.*;
import java.util.Locale;
import java.util.Objects;

public final class Game {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static QuestionTree tree;

    public static void main(String[] args) {
        loadTree();
        System.out.println("Let's play a game!");
        System.out.println("You think of an animal, and I have to find out which one it is!");
        mainLoop();
    }

    private static void mainLoop() {
        var switchFlag = false;
        if (tree.getRoot() == null || tree.getCurrent() == null) return;
        System.out.println("(d: tree diagram)");
        System.out.println("(q: quit)");
        System.out.println(tree.getCurrent().getData() + " (y/n)");
        var inputString = inputPrompt().toLowerCase(Locale.ROOT);
        if (Objects.equals(inputString, "q")) {
            saveTree();
            return;
        }
        if (Objects.equals(inputString, "d")) tree.print();
        if (Objects.equals(inputString, "y")) {
            if (tree.getCurrent().getYes() != null)
                tree.setCurrent(tree.getCurrent().getYes());
            else {
                if (tree.getCurrent().isAnimal()) {
                    System.out.println("I knew it!\nLet's play again!");
                    tree.setCurrent(tree.getRoot());
                }
                else {
                    inputString = "n";
                    switchFlag = true;
                }
            }
        }
        if (Objects.equals(inputString, "n")) {
            if (tree.getCurrent().getNo() != null && !switchFlag)
                tree.setCurrent(tree.getCurrent().getNo());
            else {
                System.out.println("Really? I have no idea then!\nWhat animal was it?");
                var animalString = inputPrompt();
                System.out.println("Please enter a yes/no question for " + animalString + ":");
                var questionString = inputPrompt();
                if (!questionString.endsWith("?")) questionString += "?";
                System.out.println("And what would the answer be? (y/n)");
                var answerString = inputPrompt().toLowerCase(Locale.ROOT);
                while (!(Objects.equals(answerString, "y")) && !(Objects.equals(answerString, "n"))) {
                    System.out.println("Please enter y or n:");
                    answerString = inputPrompt().toLowerCase(Locale.ROOT);
                }
                var question = new Question(questionString);
                var animalQuestion = new Question("Is it a " + animalString + "?");
                animalQuestion.setAnimal(true);
                if (Objects.equals(answerString, "y")) question.setYes(animalQuestion);
                if (Objects.equals(answerString, "n")) question.setNo(animalQuestion);
                if (switchFlag) tree.getCurrent().setYes(question);
                else tree.getCurrent().setNo(question);
                System.out.println("Okay!\nLet's play again!");
                tree.setCurrent(tree.getRoot());
            }
        }
        mainLoop();
    }

    private static String inputPrompt() {
        try {
            var readString = reader.readLine();
            return readString.equals("") ? inputPrompt() : readString;
        }
        catch (IOException ignored) {
            System.out.println("Something went wrong. Please try again.");
            return inputPrompt();
        }
    }

    private static void saveTree() {
        try {
            final var objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.dat"));
            objectOutputStream.writeObject(tree);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch (IOException ignored) {
            System.out.println("Error saving data.");
        }
    }

    private static void loadTree() {
        try {
            final var file = new File("tree.dat");
            if (file.exists() && !file.isDirectory()) {
                final var objectInputStream = new ObjectInputStream(new FileInputStream("tree.dat"));
                tree = (QuestionTree) objectInputStream.readObject();
                objectInputStream.close();
            }
            else {
                tree = new QuestionTree();
                tree.setRoot(new Question("Is it a mammal?"));
                tree.setCurrent(tree.getRoot());
            }
        }
        catch (IOException | ClassNotFoundException ignored) {
            System.out.println("Error loading data.");
        }
    }
}
