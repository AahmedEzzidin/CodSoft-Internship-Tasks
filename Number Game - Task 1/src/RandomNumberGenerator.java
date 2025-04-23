import java.util.Random;

public class RandomNumberGenerator {
    public static int getRandomNumber()
    {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }
}
