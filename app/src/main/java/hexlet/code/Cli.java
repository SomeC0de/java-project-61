package hexlet.code;
import java.util.Scanner;
public class Cli {
    public static final String ID_GREETING = "1";
    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
