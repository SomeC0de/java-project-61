package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Random;
import java.util.Scanner;

public class Calc implements GameInterface {
    private static String userName;
    Scanner inputScan;
    private final static int LOW_LIMIT = -10;
    private final static int HIGH_LIMIT = 10;
    private final static int MULTIPLY = 0;
    private final static int ADD = 1;
    private final static int SUBTRACT = 2;
    private static int result;
    int answerUser;
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
        System.out.println("What is the result of the expression?");
    }
    public void generateQuestion() {
        generateAndShow();
    }
    public void getAnswer() {
        answerUser = inputScan.nextInt();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;

        if (answerUser == result) {
            isCorrect = true;
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

    private static int calculateResult(int first, int second, int action) {
        int result = 0;

        switch (action) {
            case MULTIPLY:
                result = first * second;
                break;
            case ADD:
                result = first + second;
                break;
            case SUBTRACT:
                result = first - second;
                break;
            default:
                new RuntimeException("unknown action: " + action);
                break;
        }
        return result;
    }

    private static void generateAndShow () {
        int actionId = RandomGenerator.generateRandomInt(MULTIPLY, SUBTRACT);
        int firstValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        int secondValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        String actionWord = null;

        result = calculateResult (firstValue, secondValue, actionId);

        switch (actionId) {
            case MULTIPLY:
                System.out.println("Question: " + firstValue + " * " + secondValue);
                break;
            case ADD:
                System.out.println("Question: " + firstValue + " + " + secondValue);
                break;
            case SUBTRACT:
                System.out.println("Question: " + firstValue + " - " + secondValue);
                break;
            default:
                new RuntimeException("unknown action: " + actionId);
                break;
        }
    }
}
