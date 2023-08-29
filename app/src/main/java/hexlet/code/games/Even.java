package hexlet.code.games;
import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public final class Even implements GameInterface {
    private static String userName;
    private static Scanner inputScan;
    private static int newVal;
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    private static String answerUser;
    public void initGame() {
        inputScan = new Scanner(System.in);
    }
    public void sayHello() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        userName = inputScan.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public void explainRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public void generateQuestion() {
        newVal = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        System.out.println("Question: " + newVal);
    }
    public void getAnswer() {
        answerUser = inputScan.nextLine();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;
        String answerCorrect = (0 == (newVal % 2)) ? "yes" : "no";

        if (answerUser.equals(answerCorrect)) {
            System.out.println("Correct!");
            isCorrect = true;
        } else {
            System.out.println("'" + answerUser + "' is wrong answer ;(. Correct answer was '"
                    + answerCorrect + "'.");
        }

        return isCorrect;
    }
    public void sayGoodbye(int correctAttempts, int winCondition) {
        if (winCondition == correctAttempts) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
