package hexlet.code;
public class Engine {
    private static final int TRIAL_MAX_CNT = 3;

    public static void runEngine(GameInterface game) {
        int trialNum;

        game.initGame();
        game.sayHello();
        game.explainRules();

        for (trialNum = 0; trialNum < TRIAL_MAX_CNT; trialNum++) {
            game.generateQuestion();
            game.getAnswer();

            if (!game.isAnswerCorrect()) {
                break;
            }
        }
        game.sayGoodbye(trialNum, TRIAL_MAX_CNT);
    }
}
