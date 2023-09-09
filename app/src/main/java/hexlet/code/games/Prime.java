package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

public final class Prime implements GameInterface {
    public static final String ID_PRIME = "6";
    private static final int LOW_LIMIT = 1;
    private static final int HIGH_LIMIT = 100;
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public String[] getGameData() {
        String[] gameData = new String[GAME_DATA_LEN];
        int questionValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        gameData[GAME_DATA_QUEST_IDX] = Integer.toString(questionValue);
        gameData[GAME_DATA_ANSW_IDX] = isPrime(questionValue);

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
