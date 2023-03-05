import java.util.Scanner;

public class TicTacToe {
    private String[][] board;
    private int turn;
    
    public TicTacToe() {
        board = new String[3][3];
        turn = 0; // X's turn
    }
    
    public int getTurn() {
        return turn;
    }
    
    public void printBoard() {
        // Finish this method to match the output in the directions!
        System.out.println("  0 1 2");

        for (int r = 0; r < board.length; r++) {
            System.out.print(r + " ");

            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean pickLocation(int row, int column) {
        return row < board.length && column < board.length && board[row][column] != "X" && board[row][column] != "O";
    }

    public void takeTurn(int row, int column) {
        if (pickLocation(row, column)) {
            if (turn % 2 == 0) {
                board[row][column] = "X";
            } else {
                board[row][column] = "O";
            }
            turn++;
        } else {
            System.out.println("Not a valid position. Please try again!");
        }
    }

    public boolean checkWin(int turn) {
        return checkColumn(turn) || checkRow(turn) || checkDiag(turn);
    }

    public boolean checkColumn(int turn) {
        if (turn % 2 == 0) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == "X" && board[i][1] == "X" && board[i][2] == "X") {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        } else {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == "O" && board[i][1] == "O" && board[i][2] == "O") {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        }
    }
    
    public boolean checkRow(int turn) {
        if (turn % 2 == 0) {
            for (int i = 0; i < board.length; i++) {
                if (board[0][i] == "X" && board[1][i] == "X" && board[2][i] == "X") {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        } else {
            for (int i = 0; i < board.length; i++) {
                if (board[0][i] == "O" && board[1][i] == "O" && board[2][i] == "O") {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        }
    }

    public boolean checkDiag(int turn) {
        if (turn % 2 == 0) {
            return (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") || (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X");
        } else {
            return (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") || (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O");
        }
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board.length; j++) {
                game.board[i][j] = "-";
            }
        }
        
        while (true) {
            System.out.println("Player " + ((game.turn % 2) + 1) + ": Enter your choice's row");
            int row = input.nextInt();
            int column = input.nextInt();
            
            game.takeTurn(row, column);
            game.printBoard();

            if (game.checkWin((game.turn - 1))) {
                System.out.println("Player " + (((game.turn - 1) % 2) + 1) + " wins!");
                break;
            }
        }
        input.close();
        // Test your other methods here as well!
    }
}