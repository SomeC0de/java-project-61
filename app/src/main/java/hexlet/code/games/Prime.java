package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Prime implements Game {
    private static final int LOW_LIMIT = 1;
    private static final int HIGH_LIMIT = 100;
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public String[] getData() {
        String[] gameData = new String[ELEMENTS_AMOUNT];
        int questionValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        gameData[QUESTION] = Integer.toString(questionValue);
        gameData[ANSWER] = isPrime(questionValue);

        return gameData;
    }
    private static String isPrime(int value) {
        if (value <= 1) {
            return "no";
        }

        for (int idx = 2; idx < value / 2; idx++) {
            if ((value % idx) == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
