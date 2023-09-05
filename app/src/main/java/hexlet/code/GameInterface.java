package hexlet.code;

public interface GameInterface {
    String getRules();
    void generateQuestion();
    void getAnswer();
    boolean isAnswerCorrect();
    void sayGoodbye(int result, int winCondition);
}
