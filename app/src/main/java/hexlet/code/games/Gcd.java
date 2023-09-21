package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Gcd implements Game {
    private static final int LOW_LIMIT = 0;
    private static final int HIGH_LIMIT = 100;
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    public String[] getData() {
        String[] gameData = new String[ELEMENTS_AMOUNT];
        int first = RandomGenerator.getInt(LOW_LIMIT, HIGH_LIMIT);
        int second = RandomGenerator.getInt(LOW_LIMIT, HIGH_LIMIT);
        int gcd = calculateGcd(first, second);

        gameData[QUESTION] = first + " " + second;
        gameData[ANSWER] = Integer.toString(gcd);

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
