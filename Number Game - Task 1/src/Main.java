import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
int randomIntStore;
public class NumberGame {

    public void numberGame() {

        // The numberGame method contains the logic
        Scanner scanner=new Scanner(System.in);

        // Initializing the player's score.
        int score = 0;

        // Prompt the user to enter the number of chances they want to have for guessing.
        System.out.print("\nEnter Number Of Chances: ");
        int chances= scanner.nextInt();
        chances = chances-1;

        // Using a for loop to control the number of guessing attempts.
        for (;chances >=0;chances--) {
            ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
            Runnable task = () -> {
                System.out.print("\nYou Can Guess the Number Now ");
                System.out.print("\nEnter Your Guessing: ");
            };

            schedular.schedule(task, 1, TimeUnit.SECONDS);// Schedule the task to run after 1 second.
            int userGuess = scanner.nextInt();
            if (userGuess < randomIntStore) {
                if (chances==0) {
                    // If the user has run out of chances, tell them they lost and reveal the correct answer.
                    System.out.print("***** Too low. Better Luck Next Time *****");
                    System.out.print("\nThe Answer is: " + randomIntStore);
                    schedular.shutdown();
                }else{System.out.print("Too low, try again\nNow You Have " + chances +" Chances");}
            } else if(userGuess > randomIntStore) {
                if (chances==0) {
                    // If the user has run out of chances, tell them they lost and reveal the correct answer.
                    System.out.print("Too high. Better Luck Next Time.");
                    System.out.print("\nThe Answer is: " + randomIntStore);
                    schedular.shutdown();
                }else{System.out.print("Too high, try again.\nNow You Have " + chances +" Chances");}
            } else{
                // If the user's guess is correct.
                //Score is equal to number of remaining chances multiplied by 100
                    score = chances*100;
                    schedular.shutdown();
                    System.out.print("Your guess is correct. Good Job!\n***** Your Score is "+ score + " *****");
                break;// Exit the loop since the user guessed correctly.
            }
        }
        // Ask the user if they want to play again.
        System.out.print("\n***** Do You Want To Play Again? *****\n");
        System.out.print("(Yes/No): ");
    }
}

public void main(String[] args) {

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    // Generate a random number between 1 and 100 (inclusive).
    randomIntStore = randomNumberGenerator.getRandomNumber();
    Scanner scanner = new Scanner(System.in);

    System.out.print("***** Welcome to the Number Game ***** \nEnter Your Name : ");
    String name = scanner.nextLine();

    System.out.print("***** Welcome " + name +"!"+" *****" +"\nGetting the Random Number From 1 to 100...");
    NumberGame numberGame= new NumberGame();
    numberGame.numberGame();
    String answer = scanner.nextLine();
    // Use a while loop to allow the user to play multiple games.  The loop continues as long as
    // the user enters "yes" (case-insensitive).
    while(answer.equalsIgnoreCase("yes")){
        // Generate a new random number for the next game.
        randomIntStore = randomNumberGenerator.getRandomNumber();
        numberGame.numberGame();//restart the game
        answer = scanner.nextLine();//get the answer
    }
    scanner.close();
    System.out.print("***** Thanks For Playing Number Game *****\n");
    System.out.print("***** Goodbye *****");
    System.exit(0);
}