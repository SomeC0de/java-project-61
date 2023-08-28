package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actionType;

        while (true) {

            System.out.println("Please enter the game number and press Enter.");
            System.out.println(
                    "1 - Greet\n"
                    + "2 - Even\n"
                    + "3 - Calculator\n"
                    + "4 - GCD\n"
                    + "5 - Progression\n"
                    + "6 - Prime\n"
                    + "0 - Exit");

            boolean isExit = false;
            actionType = scanner.nextLine();

            System.out.println("Your choice: " + actionType + "\n");

            switch (actionType) {
                case "0":
                    isExit = true;
                    break;

                case "1":
                    Cli.greetings();
                    isExit = true;
                    break;

                case "2":
                    Engine newGameEven = new Engine();
                    newGameEven.runEngine(Engine.ID_GAME_EVEN);
                    isExit = true;
                    break;

                case "3":
                    Engine newGameCalc = new Engine();
                    newGameCalc.runEngine(Engine.ID_GAME_CALC);
                    isExit = true;
                    break;

                case "4":
                    Engine newGameGcd = new Engine();
                    newGameGcd.runEngine(Engine.ID_GAME_GCD);
                    isExit = true;
                    break;

                case "5":
                    Engine newGameProgression = new Engine();
                    newGameProgression.runEngine(Engine.ID_GAME_PROGRESSION);
                    isExit = true;
                    break;

                case "6":
                    Engine newGamePrime = new Engine();
                    newGamePrime.runEngine(Engine.ID_GAME_PRIME);
                    isExit = true;
                    break;

                default:
                    System.out.println("Unknown character");
                    isExit = true;
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
