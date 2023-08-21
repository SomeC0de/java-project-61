package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.GameInterface;

import java.util.Scanner;

public class Engine {
    final int trialsCountMax = 3;
    final int idGameEven = 2;
    final int idGameCalc = 3;
    Scanner inputScan;
    Even gameEven = new Even();
    GameInterface[] arrayGamesMethods = {null, null, gameEven};

    public void runEngine(int idGame) {
        int trialNum = 0;
        switch (idGame) {
            case idGameEven:
            case idGameCalc:
                arrayGamesMethods[idGame].initGame();
                arrayGamesMethods[idGame].sayHello();
                arrayGamesMethods[idGame].explainRules();

                for (trialNum = 0; trialNum < trialsCountMax; trialNum++) {
                    arrayGamesMethods[idGame].generateQuestion();
                    arrayGamesMethods[idGame].getAnswer();

                    if (!arrayGamesMethods[idGame].isAnswerCorrect()) {
                        break;
                    }
                }

                arrayGamesMethods[idGame].sayGoodbye(trialNum, trialsCountMax);
                break;

            default:
                break;
        }
    }
}
