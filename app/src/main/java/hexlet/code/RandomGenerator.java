package hexlet.code;

public class RandomGenerator {
    public static int generateRandomInt(int lowLimit, int highLimit) {
        return (int) Math.floor(Math.random() * (highLimit - lowLimit + 1)) + lowLimit;
    }
}
