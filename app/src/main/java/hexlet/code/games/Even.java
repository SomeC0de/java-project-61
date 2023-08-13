package hexlet.code.games;
import java.util.Random;
import java.util.Scanner;

public class Even implements GameInterface {
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
        System.out.println("May I have your name?");

        userName = inputScan.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public void explainRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");
    }
    public void generateQuestion() {
        int newVal = rand.nextInt();
        System.out.println("Question: " + newVal);
    }
    public void getAnswer() {
        answerUser = inputScan.nextLine();
    }
    public boolean isAnswerCorrect() {
        boolean isCorrect = false;
        String answerCorrect = (0 == (newVal % 2)) ? "yes" : "no";

        if (answerUser.equals(answerCorrect)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answerUser + "' is wrong answer ;(. Correct answer was '"
                    + answerCorrect + "'.");
        }

        return isCorrect;
    }
    public void sayGoodbye(int correctAttempts) {

        if (3 == correctAttempts) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    public static void play() {
        int cntTrial = 0;
        for (cntTrial = 0; cntTrial < 3; cntTrial++) {
        }
    }
}
