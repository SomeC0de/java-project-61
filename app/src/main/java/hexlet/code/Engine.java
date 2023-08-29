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
    private static final Even GAME_EVEN = new Even();
    private static final Calc GAME_CALC = new Calc();
    private static final Gcd GAME_GCD = new Gcd();
    private static final Progression GAME_PROGRESSION = new Progression();
    private static final Prime GAME_PRIME = new Prime();
    private static final GameInterface[] GAMES_LIST;

    static {
        GAMES_LIST = new GameInterface[]{null, null, GAME_EVEN, GAME_CALC, GAME_GCD, GAME_PROGRESSION, GAME_PRIME};
    }

    public void runEngine(int idGame) {
        int trialNum;

        switch (idGame) {
            case ID_GAME_EVEN, ID_GAME_CALC, ID_GAME_GCD, ID_GAME_PROGRESSION, ID_GAME_PRIME -> {
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
            }
            default -> {
            }
        }
    }
}
