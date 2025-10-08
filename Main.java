import java.util.Scanner;

class Game {

    Scanner input; 

    // constructor receives the Scanner from main
    Game(Scanner input) {
        this.input = input;
    }

    String getComputerPick() {

        String computerPick;
        // get an integer from 1 to 3
        int randomNumber = (int) (Math.random() * 3) + 1;

        if (randomNumber == 1) {
            computerPick = "rock";
        } else if (randomNumber == 2) {
            computerPick = "paper";
        } else {
            computerPick = "scissors";
        }

        return computerPick;
    }

    String getUserPick() {

        String userPick;

        // get input until user enters "rock", "paper" or "scissors"
        while (true) {
            System.out.println("Enter rock, paper or scissors:");
            userPick = input.nextLine().toLowerCase();
            if (userPick.equals("rock") || userPick.equals("paper") || userPick.equals("scissors")) {
                break;
            }
        }

        return userPick;
    }

    // return either "win", "lose" or "draw"
    String getResult(String userPick, String computerPick) {

        // condition for user to draw
        if (userPick.equals(computerPick)) {
            return "draw";
        }

        // condition for user to win
        else if (userPick.equals("paper") && computerPick.equals("rock")) {
            return "win";
        } else if (userPick.equals("rock") && computerPick.equals("scissors")) {
            return "win";
        } else if (userPick.equals("scissors") && computerPick.equals("paper")) {
            return "win";
        }

        // all conditions result in loss
        else {
            return "lose";
        }
    }
}

class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Game game = new Game(input); // pass same scanner to Game

        while (true) {

            String userPick = game.getUserPick();
            String computerPick = game.getComputerPick();
            String result = game.getResult(userPick, computerPick);

            System.out.println("User Pick: " + userPick);
            System.out.println("Computer Pick: " + computerPick);
            System.out.println("You " + result);

            System.out.println("Do you want to play again? (y/n): ");
            String playAgain = input.nextLine().toLowerCase();

            // if user enters any other character other than y, the game ends
            if (!(playAgain.equals("y"))) {
                break;
            }
        }

        input.close();
    }
}
