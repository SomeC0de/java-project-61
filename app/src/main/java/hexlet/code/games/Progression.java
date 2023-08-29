package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

import java.util.Scanner;

public final class Progression implements GameInterface {
    private static String userName;
    private static Scanner inputScan;
    private static final int STEP_LOW_LIMIT = 1;
    private static final int STEP_HIGH_LIMIT = 10;
    private static final int LENGTH_LOW_LIMIT = 5;
    private static final int LENGTH_HIGH_LIMIT = 10;
    private static final int START_VALUE_LOW_LIMIT = 0;
    private static final int START_VALUE_HIGH_LIMIT = 20;
    private static int missedValue;
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
        System.out.println("What number is missing in the progression?");
    }
    public void generateQuestion() {
        generateAndShow();
    }
    public void getAnswer() {
        answerUser = inputScan.nextInt();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;

        System.out.println("Your answer: " + answerUser);

        if (answerUser == missedValue) {
            System.out.println("Correct!");
            isCorrect = true;
        } else {
            System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was "
                    + "'" + missedValue + "'");
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

    private static int[] generateProgression(int step, int length, int initVal) {
        int[] progression = new int[length];
        int nextVal = 0;

        for (int idx = 0; idx < progression.length; idx++, nextVal += step) {
            progression[idx] = initVal + nextVal;
        }
        return progression;
    }

    private static void generateAndShow() {
        int seqStartValue = RandomGenerator.generateRandomInt(START_VALUE_LOW_LIMIT, START_VALUE_HIGH_LIMIT);
        int seqLength = RandomGenerator.generateRandomInt(LENGTH_LOW_LIMIT, LENGTH_HIGH_LIMIT);
        int seqStep = RandomGenerator.generateRandomInt(STEP_LOW_LIMIT, STEP_HIGH_LIMIT);

        int[] arithmeticProgression = generateProgression(seqStep, seqLength, seqStartValue);
        int missedIdx = RandomGenerator.generateRandomInt(0, seqLength - 1);

        missedValue = arithmeticProgression[missedIdx];

        System.out.print("Question: ");

        for (int idx = 0; idx < arithmeticProgression.length; idx++) {
            if (idx != missedIdx) {
                System.out.print(arithmeticProgression[idx] + " ");
            } else {
                System.out.print(".. ");
            }
        }
        System.out.println("");
    }
}
