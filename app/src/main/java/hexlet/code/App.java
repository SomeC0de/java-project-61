package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Even;

import hexlet.code.games.Calc;

import hexlet.code.games.Gcd;

import hexlet.code.games.Progression;

import hexlet.code.games.Prime;

public class App {
    private static final String EXIT_ID = "0";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actionId;

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(
                Cli.ID_GREETING +  " - Greet\n"
                + Even.ID_EVEN + " - Even\n"
                + Calc.ID_CALC + " - Calculator\n"
                + Gcd.ID_GCD + " - GCD\n"
                + Progression.ID_PROGRESSION + " - Progression\n"
                + Prime.ID_PRIME + " - Prime\n"
                + EXIT_ID + " - Exit");

        actionId = scanner.nextLine();

        System.out.println("Your choice: " + actionId + "\n");

        switch (actionId) {
            case EXIT_ID:
                break;

            case Cli.ID_GREETING:
                Cli.greetings();
                break;

            case Even.ID_EVEN:
                Even gameEven = new Even();
                Engine.run(gameEven);
                break;

            case Calc.ID_CALC:
                Calc gameCalc = new Calc();
                Engine.run(gameCalc);
                break;

            case Gcd.ID_GCD:
                Gcd gameGcd = new Gcd();
                Engine.run(gameGcd);
                break;

            case Progression.ID_PROGRESSION:
                Progression gameProgression = new Progression();
                Engine.run(gameProgression);
                break;

            case Prime.ID_PRIME:
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
