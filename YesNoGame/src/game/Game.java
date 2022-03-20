package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Objects;

public final class Game {
    private static final QuestionTree tree = new QuestionTree();

    public static void main(String[] args) {
        mainLoop();
    }

    private static void mainLoop() {
        var choice = waitForInput();
        if (Objects.equals(choice, "q")) return;
        mainLoop();
    }

    private static String waitForInput() {
        final var reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            var input = reader.readLine().toLowerCase(Locale.ROOT);
            if (!Objects.equals(input, "y") && !Objects.equals(input, "n") && !Objects.equals(input, "q"))
                throw new IllegalArgumentException();
            return input;
        }
        catch (IllegalArgumentException | IOException ignored) {
            System.out.println("Invalid input. Please try again.");
            return waitForInput();
        }
    }
}
