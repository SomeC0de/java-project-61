package hexlet.code;

import hexlet.code.games.Even;

import hexlet.code.games.Calc;

import hexlet.code.games.Gcd;

import hexlet.code.games.Progression;
public class Engine {
    private static final int TRIAL_MAX_CNT = 3;
    public static final int ID_GAME_EVEN = 2;
    public static final int ID_GAME_CALC = 3;
    public static final int ID_GAME_GCD = 4;
    public static final int ID_GAME_PROGESSION = 5;
    Even gameEven = new Even();
    Calc gameCalc = new Calc();
    Gcd gameGcd = new Gcd();
    Progression gameProgression = new Progression();
    GameInterface[] arrayGamesMethods = {null, null, gameEven, gameCalc, gameGcd, gameProgression};

    public void runEngine(int idGame) {
        int trialNum;

        switch (idGame) {
            case ID_GAME_EVEN:
            case ID_GAME_CALC:
            case ID_GAME_GCD:
            case ID_GAME_PROGESSION:
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
