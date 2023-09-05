package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int TRIAL_MAX_CNT = 3;
    private static String userId;
    private static Scanner scanEngine;
    public static void runEngine(GameInterface game) {
        int trialNum;
        scanEngine = new Scanner(System.in);

        greetings();
        System.out.println(game.getRules());

        for (trialNum = 0; trialNum < TRIAL_MAX_CNT; trialNum++) {
            game.generateQuestion();
            game.getAnswer();

            if (!game.isAnswerCorrect()) {
                break;
            }
        }
        game.sayGoodbye(trialNum, TRIAL_MAX_CNT);
    }

    private static String scanUserId() {
        return scanEngine.nextLine();
    }
    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        userId = scanUserId();

        System.out.println("Hello, " + userId + "!");
    }
}
