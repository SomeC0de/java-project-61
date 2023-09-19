package hexlet.code.games;
import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Even implements Game {
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public String[] getData() {
        String[] gameData = new String[ELEMENTS_AMOUNT];
        int questionVal = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        gameData[QUESTION] = Integer.toString(questionVal);
        gameData[ANSWER] = isEven(questionVal) ? "yes" : "no";

        return gameData;
    }

    private static boolean isEven(int val) {
        return ((val % 2) == 0);
    }
}
