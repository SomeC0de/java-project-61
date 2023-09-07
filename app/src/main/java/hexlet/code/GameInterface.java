package hexlet.code;

public interface GameInterface {
    public static final int GAME_DATA_QUEST_IDX = 0;
    public static final int GAME_DATA_ANSW_IDX = 1;
    public static final int GAME_DATA_LEN = 2;
    String getRules();
    String[] getGameData();
}
