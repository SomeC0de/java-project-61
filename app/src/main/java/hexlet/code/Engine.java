package hexlet.code;

import hexlet.code.games.Even;

import hexlet.code.games.Calc;

import hexlet.code.games.Gcd;

import hexlet.code.games.Progression;

import hexlet.code.games.Prime;
public class Engine {
    private static final int TRIAL_MAX_CNT = 3;
    public static final int ID_GAME_EVEN = 2;
    public static final int ID_GAME_CALC = 3;
    public static final int ID_GAME_GCD = 4;
    public static final int ID_GAME_PROGRESSION = 5;
    public static final int ID_GAME_PRIME = 6;
    private Even gameEven = new Even();
    private Calc gameCalc = new Calc();
    private Gcd gameGcd = new Gcd();
    private Progression gameProgression = new Progression();
    private Prime gamePrime = new Prime();
    private GameInterface[] arrayGamesMethods = {null, null, gameEven, gameCalc, gameGcd, gameProgression, gamePrime};

    public void runEngine(int idGame) {
        int trialNum;

        switch (idGame) {
            case ID_GAME_EVEN:
            case ID_GAME_CALC:
            case ID_GAME_GCD:
            case ID_GAME_PROGRESSION:
            case ID_GAME_PRIME:
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
