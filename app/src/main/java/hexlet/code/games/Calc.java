package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public final class Calc implements GameInterface {
    public static final String ID_CALC = "3";
    private static String userName;
    private Scanner inputScan;
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    private static final int MULTIPLY = 0;
    private static final int ADD = 1;
    private static final int SUBTRACT = 2;
    private int result;
    private int answerUser;
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
        int actionId = RandomGenerator.generateRandomInt(MULTIPLY, SUBTRACT);
        int firstValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        int secondValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        result = calculateResult(firstValue, secondValue, actionId);

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

    private static int calculateResult(int first, int second, int action) {
        int calcValue = 0;

        switch (action) {
            case MULTIPLY:
                calcValue = first * second;
                break;
            case ADD:
                calcValue = first + second;
                break;
            case SUBTRACT:
                calcValue = first - second;
                break;
            default:
                new RuntimeException("unknown action: " + action);
                break;
        }
        return calcValue;
    }
}
