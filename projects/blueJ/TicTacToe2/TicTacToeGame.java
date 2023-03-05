import java.util.Scanner;

import javax.swing.RowFilter;

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

        while (true) {
            System.out.println("Player " + ((game.getTurn() % 2) + 1) + ": Enter play:");
                
            String entry = input.nextLine();
            
            if (entry.equals("exit")) {
                System.exit(0);
            } else {
                try {
                    int row = Integer.parseInt(entry.split(" ")[0]);
                    int col = Integer.parseInt(entry.split(" ")[1]);
                    
                    while (game.takeTurn(row, col) != 2) {
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Please enter play with format <row> <column>");
                } catch (Exception e) {
                    System.out.println("Application error: " + e);
                }

            }
        }
        
        // while (true) {
        //     if (game.checkTie()) {
        //         System.out.println("It's a Tie!");
        //         break;
        //     }

            
        //         if (game.checkWin()) {
        //             break;
        //         } else {
        //             game.setTurn(game.getTurn() + 1);
        //         }
        //     }  
        //     game.printBoard();
        // }
        //don't even ask
        System.out.println("Player " + ((game.getTurn() % 2) + 1) + " wins!\n");
        input.close();
    }
}