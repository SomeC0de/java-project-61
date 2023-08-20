package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.GameInterface;
import hexlet.code.games.GamesList;

import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Engine {
    GamesList actualGame;
    final static int ATTEMPTS_COUNT = 3;
    Scanner inputScan;
    Even gameEven = new Even();
    GameInterface[] arrayGamesMethods = {null, null, gameEven};

    public void runEngine(int gameId) {
        switch (gameId) {
            case 1:
                actualGame = GamesList.EVEN;
                break;

            case 2:
                actualGame = GamesList.CALC;
                break;

            default:
                break;
        }
    }
}
