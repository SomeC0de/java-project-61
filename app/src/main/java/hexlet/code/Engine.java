package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int TRIAL_MAX_CNT = 3;
    public static void run(Game game) {
        String userId;
        int trialNum;
        Scanner scanEngine = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        userId = scanEngine.nextLine();
        System.out.println("Hello, " + userId + "!");

        System.out.println(game.getRules());

        for (trialNum = 0; trialNum < TRIAL_MAX_CNT; trialNum++) {
            String[] actualGameData = game.getData();

            System.out.println("Question: " + actualGameData[Game.QUESTION]);
            String userAnswer = scanEngine.nextLine();
            System.out.println("Your answer: " + userAnswer);

            if (!userAnswer.equals(actualGameData[Game.ANSWER])) {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + actualGameData[Game.ANSWER] + "'");
                break;
            } else {
                System.out.println("Correct!");
            }
        }

        if (trialNum == TRIAL_MAX_CNT) {
            System.out.println("Congratulations, " + userId + "!");
        } else {
            System.out.println("Let's try again, " + userId + "!");
        }
    }
}
