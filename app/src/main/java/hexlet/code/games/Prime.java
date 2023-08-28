package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public class Prime implements GameInterface {
    private static String userName;
    Scanner inputScan;
    private static final int LOW_LIMIT = 1;
    private static final int HIGH_LIMIT = 100;
    private static int question;
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
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
    public void generateQuestion() {
        generateAndShow();
    }
    public void getAnswer() {
        answerUser = inputScan.nextLine();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;
        String answerCorrect;

        System.out.println("Your answer: " + answerUser);

        if (isPrime(question)) {
            answerCorrect = "yes";
        } else {
            answerCorrect = "no";
        }

        if (answerUser.equals(answerCorrect)) {
            System.out.println("Correct!");
            isCorrect = true;
        } else {
            System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was "
                    + "'" + answerCorrect + "'");
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

    private static void generateAndShow() {
        question = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        System.out.println("Question: " + question);
    }

    private static boolean isPrime(int value) {
        boolean isPrime = false;

        if (value > 1) {
            for (int idx = 2; idx < value / 2; idx++) {
                if (0 == (value % idx)) {
                    isPrime = false;
                    break;
                } else {
                    isPrime = true;
                }
            }
        } else {
            isPrime = true;
        }

        return isPrime;
    }
}