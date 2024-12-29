import java.util.Scanner;
import java.util.Random;  
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.println("\nStarting a new round...");
            int targetNumber = random.nextInt(100) + 1; 
            int attemptsLeft = 5;
            int roundScore = 0;
            roundsPlayed++;

            System.out.println("I have picked a number between 1 and 100. Can you guess it?");
            while (attemptsLeft > 0) {
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.print("Enter your guess: ");
                
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    roundScore = attemptsLeft * 10;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                System.out.println("You're out of attempts! The correct number was " + targetNumber + ".");
            }

            totalScore += roundScore;
            System.out.println("Round score: " + roundScore);
            System.out.println("Total score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame over! You played " + roundsPlayed + " rounds and scored a total of " + totalScore + " points.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}