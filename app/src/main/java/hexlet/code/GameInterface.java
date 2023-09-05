package hexlet.code;

public interface GameInterface {
    void sayHello();
    void explainRules();
    void generateQuestion();
    void getAnswer();
    boolean isAnswerCorrect();
    void sayGoodbye(int result, int winCondition);
}
