package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

public final class Calc implements GameInterface {
    public static final String ID_CALC = "3";
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    private static final int MULTIPLY = 0;
    private static final int ADD = 1;
    private static final int SUBTRACT = 2;
    public String getRules() {
        return "What is the result of the expression?";
    }
    public String[] getGameData() {
        String[] gameData = new String[GAME_DATA_LEN];

        int actionId = RandomGenerator.generateRandomInt(MULTIPLY, SUBTRACT);
        int firstValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);
        int secondValue = RandomGenerator.generateRandomInt(LOW_LIMIT, HIGH_LIMIT);

        switch (actionId) {
            case MULTIPLY:
                gameData[GAME_DATA_QUEST_IDX] = firstValue + " * " + secondValue;
                break;
            case ADD:
                gameData[GAME_DATA_QUEST_IDX] = firstValue + " + " + secondValue;
                break;
            case SUBTRACT:
                gameData[GAME_DATA_QUEST_IDX] = firstValue + " - " + secondValue;
                break;
            default:
                new RuntimeException("unknown action: " + actionId);
                break;
        }

        gameData[GAME_DATA_ANSW_IDX] = calculateResult(firstValue, secondValue, actionId);

        return gameData;
    }
    private static String calculateResult(int first, int second, int action) {
        int calcValue = 0;

        switch (action) {
            case MULTIPLY:
                calcValue = first * second;
                break;
            case ADD:
                calcValue = first + second;
                break;
            case SUBTRACT:
                calcValue = first - second;
                break;
            default:
                new RuntimeException("unknown action: " + action);
                break;
        }

        return Integer.toString(calcValue);
    }
}
