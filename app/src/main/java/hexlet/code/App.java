package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actionType;

        while (true) {

            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet\n" + "2 - Even\n" + "0 - Exit");

            boolean isExit = false;
            actionType = scanner.nextLine();

            System.out.println("Your choice: " + actionType + "\n");

            switch (actionType) {
                case "0":
                    isExit = true;
                    break;

                case "1":
                    System.out.println("Welcome to the Brain Games!");
                    Cli.greetings();
                    break;

                case "2":
                    System.out.println("Welcome to the Brain Games!");
                    Even.play();
                    break;

                default:
                    System.out.println("Unknown character");
                    break;
            }
            System.out.println("");

            if (isExit) {
                break;
            }
        }
        scanner.close();
    }

}
