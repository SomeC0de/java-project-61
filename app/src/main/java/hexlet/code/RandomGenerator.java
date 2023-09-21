package hexlet.code;

public class RandomGenerator {
    public static int getInt(int lowLimit, int highLimit) {
        return (int) Math.floor(Math.random() * (highLimit - lowLimit + 1)) + lowLimit;
    }
}
