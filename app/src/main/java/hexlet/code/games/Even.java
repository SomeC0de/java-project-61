package hexlet.code.games;
import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public final class Even implements GameInterface {
    public static final String ID_EVEN = "2";
    private static String userName;
    private static Scanner inputScan;
    private static int newVal;
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    private static String answerUser;
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
        String answerCorrect = isEven(newVal);

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

    private static String isEven(int val) {
        return (0 == (val % 2)) ? "yes" : "no";
    }
}
