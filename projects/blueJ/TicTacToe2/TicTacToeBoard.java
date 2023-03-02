public class TicTacToeBoard {
    private String[][] board;
    private int turn;
    
    public TicTacToeBoard() {
        board = new String[3][3];
        turn = 0; // X's turn
    }
    
    public int getTurn() {
        return turn;
    }
    public String[][] getBoard() {
        return board;
    }
    
    public void printBoard() {
        // Finish this method to match the output in the directions!
        System.out.println();
        System.out.println("  0 1 2");

        for (int r = 0; r < board.length; r++) {
            System.out.print(r + " ");

            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean pickLocation(int row, int col) {
        return row < board.length && col < board.length && board[row][col] != "X" && board[row][col] != "O";
    }

    public void takeTurn(int row, int col) {
        if (pickLocation(row, col)) {
            if (turn % 2 == 0) {
                board[row][col] = "X";
            } else {
                board[row][col] = "O";
            }
            turn++;
        } else {
            System.out.println("Error: not a valid position. Please try again!");
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
}