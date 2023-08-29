package hexlet.code;

import hexlet.code.games.Even;

import hexlet.code.games.Calc;

import hexlet.code.games.Gcd;

import hexlet.code.games.Progression;

import hexlet.code.games.Prime;
public final class Engine {
    private static final int TRIAL_MAX_CNT = 3;
    public static final int ID_GAME_EVEN = 2;
    public static final int ID_GAME_CALC = 3;
    public static final int ID_GAME_GCD = 4;
    public static final int ID_GAME_PROGRESSION = 5;
    public static final int ID_GAME_PRIME = 6;
    private final Even gameEven = new Even();
    private final Calc gameCalc = new Calc();
    private final Gcd gameGcd = new Gcd();
    private final Progression gameProgression = new Progression();
    private final Prime gamePrime = new Prime();
    private final GameInterface[] GAMES_LIST = {null, null, gameEven, gameCalc, gameGcd, gameProgression, gamePrime};

    public void runEngine(int idGame) {
        int trialNum;

        switch (idGame) {
            case ID_GAME_EVEN:
            case ID_GAME_CALC:
            case ID_GAME_GCD:
            case ID_GAME_PROGRESSION:
            case ID_GAME_PRIME:
                GAMES_LIST[idGame].initGame();
                GAMES_LIST[idGame].sayHello();
                GAMES_LIST[idGame].explainRules();

                for (trialNum = 0; trialNum < TRIAL_MAX_CNT; trialNum++) {
                    GAMES_LIST[idGame].generateQuestion();
                    GAMES_LIST[idGame].getAnswer();

                    if (!GAMES_LIST[idGame].isAnswerCorrect()) {
                        break;
                    }
                }

                GAMES_LIST[idGame].sayGoodbye(trialNum, TRIAL_MAX_CNT);
                break;

            default:
                break;
        }
    }
}
