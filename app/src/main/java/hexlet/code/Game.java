package hexlet.code;

public interface Game {
    int QUESTION = 0;
    int ANSWER = 1;
    int GAME_DATA_LEN = 2;
    String getRules();
    String[] getData();
}
