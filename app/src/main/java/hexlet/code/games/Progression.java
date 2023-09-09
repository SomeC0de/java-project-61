package hexlet.code.games;

import hexlet.code.GameInterface;
import hexlet.code.RandomGenerator;

public final class Progression implements GameInterface {
    public static final String ID_PROGRESSION = "5";
    private static final int STEP_LOW_LIMIT = 1;
    private static final int STEP_HIGH_LIMIT = 10;
    private static final int LENGTH_LOW_LIMIT = 5;
    private static final int LENGTH_HIGH_LIMIT = 10;
    private static final int START_VALUE_LOW_LIMIT = 0;
    private static final int START_VALUE_HIGH_LIMIT = 20;
    public String getRules() {
        return "What number is missing in the progression?";
    }
    public String[] getGameData()  {
        String[] gameData = new String[GAME_DATA_LEN];

        int seqStartValue = RandomGenerator.generateRandomInt(START_VALUE_LOW_LIMIT, START_VALUE_HIGH_LIMIT);
        int seqLength = RandomGenerator.generateRandomInt(LENGTH_LOW_LIMIT, LENGTH_HIGH_LIMIT);
        int seqStep = RandomGenerator.generateRandomInt(STEP_LOW_LIMIT, STEP_HIGH_LIMIT);

        int[] arithmeticProgression = generateProgression(seqStep, seqLength, seqStartValue);
        int missedIdx = RandomGenerator.generateRandomInt(0, seqLength - 1);

        gameData[GAME_DATA_ANSW_IDX] = Integer.toString(arithmeticProgression[missedIdx]);

        gameData[GAME_DATA_QUEST_IDX] = "";
        for (int idx = 0; idx < arithmeticProgression.length; idx++) {
            if (idx != missedIdx) {
                gameData[GAME_DATA_QUEST_IDX] += arithmeticProgression[idx] + " ";
            } else {
                gameData[GAME_DATA_QUEST_IDX] += ".. ";
            }
        }

        return gameData;
    }

    private static int[] generateProgression(int step, int length, int initVal) {
        int[] progression = new int[length];
        int nextVal = 0;

        for (int idx = 0; idx < progression.length; idx++, nextVal += step) {
            progression[idx] = initVal + nextVal;
        }
        return progression;
    }
}
