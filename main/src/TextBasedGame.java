import java.util.Scanner;

public class TextBasedGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int secretNumber = (int) (Math.random() * 100) + 1;
            int attempts = 0;
            boolean isGameOver = false;
            String playerName;

            System.out.println("Welcome to Samson's Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.print("Enter your name: ");
            playerName = scanner.nextLine();
            System.out.println("Hello, " + playerName + "! Let's begin our guessing journey.");

            while (!isGameOver) {
                System.out.print("Take your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == (secretNumber + 5)) {
                    System.out.println("Just a little lower!");
                } else if (guess == (secretNumber - 5)) {
                    System.out.println("Just a little higher!");
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Guess a higher number!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Guess lower...");
                } else {
                    System.out.println("Congratulations, " + playerName + "! You guessed the right number " + secretNumber + " correctly!");
                    System.out.println("Number of attempts: " + attempts);
                    isGameOver = true;
                }

                if (attempts >= 5) {
                    System.out.println("Sorry, " + playerName + "! You've reached the maximum number of attempts.");
                    System.out.println("The secret number was " + secretNumber + ". Better luck next time!");
                    isGameOver = true;
                }
            }

            int score = calculateScore(attempts);
            displayScore(score);

            int[] highScores = {100, 90, 80, 70, 60}; // Example high scores
            if (isHighScore(score, highScores)) {
                System.out.println("Congratulations! You've achieved a high score!");
                displayHighScores(highScores);
            } else {
                System.out.println("Keep playing to improve your score!");
            }

            playAgain();
        }
    }

    public static int calculateScore(int attempts) {
        int score = 100 - (attempts * 10);
        return score;
    }

    public static void displayScore(int score) {
        System.out.println("Your score: " + score);
    }

    public static boolean isHighScore(int score, int[] highScores) {
        for (int highScore : highScores) {
            if (score > highScore) {
                return true;
            }
        }
        return false;
    }

    public static void displayHighScores(int[] highScores) {
        System.out.println("High Scores:");
        for (int i = 0; i < highScores.length; i++) {
            System.out.println((i + 1) + ". " + highScores[i]);
        }
    }

    public static void playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Let's play again!");
            main(null);
        } else {
            System.out.println("Thank you for playing. Goodbye!");
        }
    }
}