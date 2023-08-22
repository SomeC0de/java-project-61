package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.GameInterface;

public class Engine {
    private static final int TRIAL_MAX_CNT = 3;
    public static final int ID_GAME_EVEN = 2;
    public static final int ID_GAME_CALC = 3;
    Even gameEven = new Even();
    GameInterface[] arrayGamesMethods = {null, null, gameEven};

    public void runEngine(int idGame) {
        int trialNum;

        switch (idGame) {
            case ID_GAME_EVEN:
            case ID_GAME_CALC:
                arrayGamesMethods[idGame].initGame();
                arrayGamesMethods[idGame].sayHello();
                arrayGamesMethods[idGame].explainRules();

                for (trialNum = 0; trialNum < TRIAL_MAX_CNT; trialNum++) {
                    arrayGamesMethods[idGame].generateQuestion();
                    arrayGamesMethods[idGame].getAnswer();

                    if (!arrayGamesMethods[idGame].isAnswerCorrect()) {
                        break;
                    }
                }

                arrayGamesMethods[idGame].sayGoodbye(trialNum, TRIAL_MAX_CNT);
                break;

            default:
                break;
        }
    }
}
