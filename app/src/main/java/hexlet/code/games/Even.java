package hexlet.code.games;
import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Even implements Game {
    public static final String ID_EVEN = "2";
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public String[] getGameData() {
        String[] gameData = new String[GAME_DATA_LEN];
        int questionVal = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        gameData[GAME_DATA_QUEST_IDX] = Integer.toString(questionVal);
        gameData[GAME_DATA_ANSW_IDX] = isEven(questionVal);

        return gameData;
    }

    private static String isEven(int val) {
        return ((val % 2) == 0) ? "yes" : "no";
    }
}
