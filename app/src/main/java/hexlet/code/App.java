package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Even;

import hexlet.code.games.Calc;

import hexlet.code.games.Gcd;

import hexlet.code.games.Progression;

import hexlet.code.games.Prime;

public class App {
    private static final String EXIT = "0";
    private static final String GREETING = "1";
    private static final String EVEN = "2";
    private static final String CALC = "3";
    private static final String GCD = "4";
    private static final String PROGRESSION = "5";
    private static final String PRIME = "6";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actionId;

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(
                GREETING +  " - Greet\n"
                + EVEN + " - Even\n"
                + CALC + " - Calculator\n"
                + GCD + " - GCD\n"
                + PROGRESSION + " - Progression\n"
                + PRIME + " - Prime\n"
                + EXIT + " - Exit");

        actionId = scanner.nextLine();

        System.out.println("Your choice: " + actionId + "\n");

        switch (actionId) {
            case EXIT:
                break;

            case GREETING:
                Cli.greetings();
                break;

            case EVEN:
                Even gameEven = new Even();
                Engine.run(gameEven);
                break;

            case CALC:
                Calc gameCalc = new Calc();
                Engine.run(gameCalc);
                break;

            case GCD:
                Gcd gameGcd = new Gcd();
                Engine.run(gameGcd);
                break;

            case PROGRESSION:
                Progression gameProgression = new Progression();
                Engine.run(gameProgression);
                break;

            case PRIME:
                Prime gamePrime = new Prime();
                Engine.run(gamePrime);
                break;

            default:
                System.out.println("Unknown game number: " + actionId);
                break;
        }
        System.out.println("");
        scanner.close();
    }

}
