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
        printRules(game);

        for (trialNum = 0; trialNum < TRIAL_MAX_CNT; trialNum++) {
            String actualGameData[] = game.getGameData();
            askQuestion(actualGameData[GameInterface.GAME_DATA_QUEST_IDX]);

            String userAnswer = getAnswer();

            if (!isAnswerCorrect(userAnswer, actualGameData[GameInterface.GAME_DATA_ANSW_IDX])) {
                printTrialFault(userAnswer, actualGameData[GameInterface.GAME_DATA_ANSW_IDX]);
                break;
            } else {
                printTrialOk();
            }
        }

        sayGoodbye(userId, trialNum, TRIAL_MAX_CNT);
    }

    private static String scanUserId() {
        return scanEngine.nextLine();
    }
    private static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        userId = scanUserId();

        System.out.println("Hello, " + userId + "!");
    }

    private static void printRules(GameInterface game) {
        System.out.println(game.getRules());
    }
    private static void askQuestion(String questionData) {
        System.out.println("Question: " + questionData);
    }

    private static String getAnswer() {
        return scanEngine.nextLine();
    }

    private static void printUserAnswer(String userAnswer) {
        System.out.println("Your answer: " + userAnswer);
    }
    private static boolean isAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer) ? true : false;
    }

    private static void printTrialOk() {
        System.out.println("Correct!");
    }

    private static void printTrialFault(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer
                + "'");

    }
    private static void sayGoodbye(String userName, int correctAttempts, int winCondition) {
        if (winCondition == correctAttempts) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
