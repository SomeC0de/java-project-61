package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Even;

import hexlet.code.games.Calc;

import hexlet.code.games.Gcd;

import hexlet.code.games.Progression;

import hexlet.code.games.Prime;

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
                    Even gameEven = new Even();
                    Engine.runEngine(gameEven);
                    isExit = true;
                    break;

                case "3":
                    Calc gameCalc = new Calc();
                    Engine.runEngine(gameCalc);
                    isExit = true;
                    break;

                case "4":
                    Gcd gameGcd = new Gcd();
                    Engine.runEngine(gameGcd);
                    isExit = true;
                    break;

                case "5":
                    Progression gameProgression = new Progression();
                    Engine.runEngine(gameProgression);
                    isExit = true;
                    break;

                case "6":
                    Prime gamePrime = new Prime();
                    Engine.runEngine(gamePrime);
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
