package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.RandomGenerator;

public final class Progression implements Game {
    private static final int STEP_LOW_LIMIT = 1;
    private static final int STEP_HIGH_LIMIT = 10;
    private static final int LENGTH_LOW_LIMIT = 5;
    private static final int LENGTH_HIGH_LIMIT = 10;
    private static final int START_VALUE_LOW_LIMIT = 0;
    private static final int START_VALUE_HIGH_LIMIT = 20;
    public String getRules() {
        return "What number is missing in the progression?";
    }
    public String[] getData()  {
        String[] gameData = new String[ELEMENTS_AMOUNT];

        int startVal = RandomGenerator.getInt(START_VALUE_LOW_LIMIT, START_VALUE_HIGH_LIMIT);
        int length = RandomGenerator.getInt(LENGTH_LOW_LIMIT, LENGTH_HIGH_LIMIT);
        int step = RandomGenerator.getInt(STEP_LOW_LIMIT, STEP_HIGH_LIMIT);

        int[] progression = generateProgression(step, length, startVal);
        int missedIdx = RandomGenerator.getInt(0, length - 1);

        gameData[ANSWER] = Integer.toString(progression[missedIdx]);

        StringBuilder question = new StringBuilder("");
        for (int idx = 0; idx < progression.length; idx++) {
            if (idx != missedIdx) {
                question.append(progression[idx]);
            } else {
                question.append("..");
            }
            question.append(" ");
        }
        gameData[QUESTION] = String.valueOf(question);

        return gameData;
    }

    private static int[] generateProgression(int step, int length, int init) {
        int[] progression = new int[length];
        int nextVal = 0;

        for (int idx = 0; idx < progression.length; idx++, nextVal += step) {
            progression[idx] = init + nextVal;
        }
        return progression;
    }
}
