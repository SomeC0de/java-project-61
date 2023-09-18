package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Gcd implements Game {
    public static final String ID_GCD = "4";
    private static final int LOW_LIMIT = 0;
    private static final int HIGH_LIMIT = 100;
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    public String[] getData() {
        String[] gameData = new String[GAME_DATA_LEN];
        int firstValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        int secondValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        int gcdValue = calculateGcd(firstValue, secondValue);

        gameData[QUESTION] = firstValue + " " + secondValue;
        gameData[ANSWER] = Integer.toString(gcdValue);

        return gameData;
    }

    private static int calculateGcd(int first, int second) {
        int calcValue;

        if (0 == second) {
            calcValue = first;
        } else {
            calcValue = calculateGcd(second, first % second);
        }

        return calcValue;
    }
}
