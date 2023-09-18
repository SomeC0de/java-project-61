package hexlet.code;

public interface Game {
    int GAME_DATA_QUEST_IDX = 0;
    int GAME_DATA_ANSW_IDX = 1;
    int GAME_DATA_LEN = 2;
    String getRules();
    String[] getGameData();
}
