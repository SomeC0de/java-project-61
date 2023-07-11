package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" + "0 - Exit");
        Scanner scanner = new Scanner(System.in);
        String gameType;
        while (true) {
            boolean isExit = false;
            gameType = scanner.nextLine();

            System.out.println("Your choice: " + gameType);
            switch (gameType) {
                case "0":
                    isExit = true;
                    break;

                case "1":
                    Cli.greetings();
                    break;

                default:
                    System.out.println("Unknown character");
                    break;
            }

            if (isExit) {
                break;
            }
        }
        scanner.close();
    }

}
