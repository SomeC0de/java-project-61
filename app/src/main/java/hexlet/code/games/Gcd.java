package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public final class Gcd implements GameInterface {
    private static String userName;
    private static Scanner inputScan;
    private static final int LOW_LIMIT = 0;
    private static final int HIGH_LIMIT = 100;
    private static int result;
    private static int answerUser;
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
        System.out.println("Find the greatest common divisor of given numbers.");
    }
    public void generateQuestion() {
        int firstValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        int secondValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        result = calculateGcd(firstValue, secondValue);
        System.out.println("Question: " + firstValue + " " + secondValue);
    }
    public void getAnswer() {
        answerUser = inputScan.nextInt();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;

        System.out.println("Your answer: " + answerUser);

        if (answerUser == result) {
            System.out.println("Correct!");
            isCorrect = true;
        } else {
            System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was "
                    + "'" + result + "'");
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

    private static int calculateGcd(int first, int second) {
        int calcValue = 0;

        if (0 == second) {
            calcValue = first;
        } else {
            calcValue = calculateGcd(second, first % second);
        }

        return calcValue;
    }
}
