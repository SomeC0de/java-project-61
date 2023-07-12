package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void play(String userName) {
        int cntTrial = 0;
        Random rand = new Random();
        Scanner inputEven = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");
        for (cntTrial = 0; cntTrial < 3; cntTrial++) {
            boolean isCorrect = false;
            int newVal = rand.nextInt();

            System.out.println("Question: " + newVal);

            String answerUser = inputEven.nextLine();
            String answerCorrect = (0 == (newVal % 2)) ? "yes" : "no";

            switch (answerUser) {
                case "yes":
                    if (0 == (newVal % 2)) {
                        isCorrect = true;
                    }
                    break;

                case "no":
                    if (0 != (newVal % 2)) {
                        isCorrect = true;
                    }
                    break;

                default:
                    break;
            }

            if (!isCorrect) {
                System.out.println("'" + answerUser + "' is wrong answer ;(. Correct answer was '"
                        + answerCorrect + "'.");
                break;
            } else {
                System.out.println("Correct!");
            }
        }

        if (3 == cntTrial) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
