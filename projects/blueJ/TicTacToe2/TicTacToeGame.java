import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToeBoard game = new TicTacToeBoard();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < game.getBoard().length; i++) {
            for (int j = 0; j < game.getBoard().length; j++) {
                game.getBoard()[i][j] = "-";
            }
        }
        game.printBoard();
        processEntry(input, game);
        input.close();
    }

    /*
     * I decided to refactor the main method so that all the user input and input
     * processing is in its own methood. This makes it easy to exit the 
     * players-taking-turns loop and end the game prematurely, like if it's a tie or 
     * a win.
     */
    public static void processEntry(Scanner scanner, TicTacToeBoard ticTacToeBoard) {
        //This first loop indicates each turn.
        while (true) {
            //turn + 1 because it makes more sense to have player 1 and 2 isntead of 0 and 1.
            System.out.println("Player " + ((ticTacToeBoard.getTurn() % 2) + 1) + ": Enter play:");
            
            /*
             * I nested this second loop because when the user makes a mistake, such 
             * as incorrectly entering their turn, I want the "Invalid position..." or 
             * the "Please enter play..." message to display instead of the "Player x:..." one.
             */
            while (true) {
                String entry = scanner.nextLine();
                
                if (entry.equals("exit")) {
                    System.exit(0);
                } else {
                    try {
                        /*
                         * user enters their turn as `x y`, so parsing is easy; just split with 
                         * whitespace as the delimiter.
                         */
                        int row = Integer.parseInt(entry.split(" ")[0]);
                        int col = Integer.parseInt(entry.split(" ")[1]);
                        
                        try {
                            //this makes it so that it'll only break out of the inner loop, advancing the turn
                            ticTacToeBoard.takeTurn(row, col);
                            break;
                        } catch (InvalidPositionException e) {
                            System.out.println("Invalid position. Please try again:");
                        } catch (GameHasTiedException e) {
                            //the return statement exits out of the method completely, allowing the program to end.
                            ticTacToeBoard.printBoard();
                            System.out.println("Tie!");
                            return;
                        } catch (GameIsWonException e) {
                            //same deal here.
                            ticTacToeBoard.printBoard();
                            System.out.println("Player " + ((ticTacToeBoard.getTurn() % 2) + 1) + " wins!\n");
                            return;
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter play with format <row> <column>:");
                    }
                }
            }
            //The positioning of the printBoard call here makes it so it prints the board regardless of whether the input was valid or not.
            ticTacToeBoard.printBoard();
        }
    }
}