package game;

import game.gameTree.GameTreeNode;
import game.gameTree.GameTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Objects;

public final class Game {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static GameTree tree;

    public static void main(String[] args) {
        loadTree();
        System.out.println("Let's play a game! I know " + tree.countAnimals() + " animals!");
        System.out.println("You think of an animal, and I have to find out which one it is!");
        mainLoop();
    }

    private static void loadTree() {
        try {
            final File file = new File("tree.dat");
            if (file.exists() && !file.isDirectory()) {
                final ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("tree.dat")));
                tree = (GameTree) objectInputStream.readObject();
                objectInputStream.close();
                tree.setCurrent(tree.getRoot());
            } else createTree();
        } catch (IOException | ClassNotFoundException ignored) {
            System.out.println("Error loading tree data.");
            createTree();
        }
    }

    private static void createTree() {
        tree = new GameTree();
        tree.setRoot(new GameTreeNode("Is it a mammal?"));
        tree.setCurrent(tree.getRoot());
    }

    private static void saveTree() {
        try {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("tree.dat")));
            objectOutputStream.writeObject(tree);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException ignored) {
            System.out.println("Error saving tree data.");
        }
    }

    private static String inputPrompt() {
        try {
            final String readString = reader.readLine();
            return readString.isEmpty() ? inputPrompt() : readString;
        } catch (IOException ignored) {
            System.out.println("Something went wrong. Please try again.");
            return inputPrompt();
        }
    }

    private static void mainLoop() {
        if (tree.getRoot() == null || tree.getCurrent() == null) return;
        boolean switchFlag = false;
        System.out.println("(d: tree diagram)");
        System.out.println("(q: quit)");
        System.out.println(tree.getCurrent().getData() + " (y/n)");
        String inputString = inputPrompt().toLowerCase(Locale.ROOT);
        if (Objects.equals(inputString, "q")) {
            saveTree();
            return;
        }
        if (Objects.equals(inputString, "d")) tree.print();
        if (Objects.equals(inputString, "y")) {
            if (tree.getCurrent().getYesNode() != null)
                tree.setCurrent(tree.getCurrent().getYesNode());
            else {
                if (tree.getCurrent().isAnimal()) {
                    System.out.println("I knew it!\nLet's play again!");
                    tree.setCurrent(tree.getRoot());
                } else {
                    inputString = "n";
                    switchFlag = true;
                }
            }
        }
        if (Objects.equals(inputString, "n")) {
            if (tree.getCurrent().getNoNode() != null && !switchFlag)
                tree.setCurrent(tree.getCurrent().getNoNode());
            else {
                System.out.println("Really? I have no idea then!\nWhat animal was it?");
                final String animalString = inputPrompt();
                System.out.println("Please enter a yes/no question for " + animalString + ":");
                String questionString = inputPrompt();
                if (!questionString.endsWith("?")) questionString += "?";
                System.out.println("And what would the answer be? (y/n)");
                String answerString = inputPrompt().toLowerCase(Locale.ROOT);
                while (!(Objects.equals(answerString, "y")) && !(Objects.equals(answerString, "n"))) {
                    System.out.println("Please enter y or n:");
                    answerString = inputPrompt().toLowerCase(Locale.ROOT);
                }
                final GameTreeNode question = new GameTreeNode(questionString);
                final GameTreeNode animalQuestion = new GameTreeNode("Is it a " + animalString + "?");
                animalQuestion.setAnimal(true);
                if (Objects.equals(answerString, "y")) question.setYesNode(animalQuestion);
                if (Objects.equals(answerString, "n")) question.setNoNode(animalQuestion);
                if (switchFlag) tree.getCurrent().setYesNode(question);
                else tree.getCurrent().setNoNode(question);
                System.out.println("Okay!\nLet's play again!");
                tree.setCurrent(tree.getRoot());
            }
        }
        mainLoop();
    }
}
