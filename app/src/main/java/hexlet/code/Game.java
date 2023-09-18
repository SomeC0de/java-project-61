package hexlet.code;

public interface Game {
    int QUESTION = 0;
    int ANSWER = 1;
    int ELEMENTS_AMOUNT = 2;
    String getRules();
    String[] getData();
}
