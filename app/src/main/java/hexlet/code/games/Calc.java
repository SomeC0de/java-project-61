package hexlet.code.games;

import hexlet.code.GameInterface;

import java.util.Random;
import java.util.Scanner;

public class Calc implements GameInterface {
    private static String userName;
    Random rand;
    Scanner inputScan;
    int newVal;
    String answerUser;
    public void initGame() {
        rand = new Random();
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
    }
    public void getAnswer() {
        answerUser = inputScan.nextLine();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;
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
