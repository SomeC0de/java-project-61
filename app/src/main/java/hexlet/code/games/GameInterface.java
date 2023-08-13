package hexlet.code.games;

public interface GameInterface {
    void initGame();
    void sayHello();
    void explainRules();
    void generateQuestion();
    void getAnswer();
    boolean isAnswerCorrect();
    void sayGoodbye(int result);
}
