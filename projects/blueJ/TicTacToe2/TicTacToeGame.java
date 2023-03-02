import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

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
        
        //bandaid fix for off-by-one error when checkWin is evaluating whose turn it is
        while (!game.checkWin(game.getTurn() - 1)) {

            System.out.println("Player " + ((game.getTurn() % 2) + 1) + ": Enter play:");
            String entry = input.nextLine();
            
            if (entry.equals("exit")) {
                System.exit(0);
            } else {
                try {
                    int row = Integer.parseInt(entry.split(" ")[0]);
                    int col = Integer.parseInt(entry.split(" ")[1]);
                    game.takeTurn(row, col);
                    
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Please enter play with format <row> <column>");
                } catch (Exception e) {
                    System.out.println("Application error: " + e);
                }
            }  
            game.printBoard();
        }
        //don't even ask
        System.out.println("Player " + (((game.getTurn() - 1) % 2) + 1) + " wins!\n");
        input.close();
    }
}