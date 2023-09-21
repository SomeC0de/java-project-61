package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Calc implements Game {
    private static final int LOW_LIMIT = -10;
    private static final int HIGH_LIMIT = 10;
    private static final int MULTIPLY = 0;
    private static final int ADD = 1;
    private static final int SUBTRACT = 2;
    public String getRules() {
        return "What is the result of the expression?";
    }
    public String[] getData() {
        String[] gameData = new String[ELEMENTS_AMOUNT];

        int actionId = RandomGenerator.getInt(MULTIPLY, SUBTRACT);
        int first = RandomGenerator.getInt(LOW_LIMIT, HIGH_LIMIT);
        int second = RandomGenerator.getInt(LOW_LIMIT, HIGH_LIMIT);

        switch (actionId) {
            case MULTIPLY:
                gameData[QUESTION] = first + " * " + second;
                break;
            case ADD:
                gameData[QUESTION] = first + " + " + second;
                break;
            case SUBTRACT:
                gameData[QUESTION] = first + " - " + second;
                break;
            default:
                throw new RuntimeException("unknown action: " + actionId);
        }

        gameData[ANSWER] = calculate(first, second, actionId);

        return gameData;
    }
    private static String calculate(int first, int second, int action) {
        int calcValue;

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
                throw new RuntimeException("unknown action: " + action);
        }

        return Integer.toString(calcValue);
    }
}
