import java.util.Random;
import java.util.Scanner;

public class numbergame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\nNew Game!");
            System.out.print("Enter the lower bound of the range: ");
            int lowerBound = sc.nextInt();
            System.out.print("Enter the upper bound of the range: ");
            int upperBound = sc.nextInt();

            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 3;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Goodbye!");
        sc.close();
    }
}
