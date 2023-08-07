package hexlet.code.games;
import java.util.Random;
import java.util.Scanner;

public class Even {
    private static String userName;
    public static void play() {
        int cntTrial = 0;
        Random rand = new Random();

        Scanner inputScan = new Scanner(System.in);
        System.out.println("May I have your name?");

        userName = inputScan.nextLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");
        for (cntTrial = 0; cntTrial < 3; cntTrial++) {
            boolean isCorrect = false;
            int newVal = rand.nextInt();

            System.out.println("Question: " + newVal);

            String answerUser = inputScan.nextLine();
            String answerCorrect = (0 == (newVal % 2)) ? "yes" : "no";

            if (answerUser.equals(answerCorrect)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answerUser + "' is wrong answer ;(. Correct answer was '"
                        + answerCorrect + "'.");
                break;
            }
        }

        if (3 == cntTrial) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
