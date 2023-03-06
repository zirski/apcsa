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
        System.out.println();
        System.out.println("  0 1 2");

        for (int r = 0; r < board.length; r++) {
            System.out.print(r + " ");

            for (int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean pickLocation(int row, int col) {
        return row < board.length && col < board.length && board[row][col] != "X" && board[row][col] != "O";
    }

    /*
     * the "throws ..." statement here indicates that this method may fail, but the
     * reasons for such wouldn't normally cause the program to crash. To do this, 
     * I made custom exceptions which are thrown if certain conditions are met (such 
     * as if the game is won or tied). I found this method a lot more readable than 
     * the alternative, which would be to put all of this logic inside the main method. 
     */
    public void takeTurn(int row, int col) throws GameHasTiedException, InvalidPositionException, GameIsWonException {
        /*
         * it's really important to first update the board, and THEN evaluate it for 
         * win, tie, etc. Otherwise off-by-one errors can occur.
         */
        if (pickLocation(row, col)) {
            //first case; turn finishes as normal
            if (turn % 2 == 0) {
                board[row][col] = "X";
            } else {
                board[row][col] = "O";
            }
        } else {
            //second case; if a player has inputted an invalid position
            throw new InvalidPositionException();
        }
        if (checkWin(turn)) {
            //third case; if the game is won due to this input
            throw new GameIsWonException();
        } 
        if (checkTie()) {
            //fourth case; if the game is tied due to this input
            throw new GameHasTiedException();
        }
        turn++;
    }
    
    /*
     * checkTie() checks for ties by checking if there is only one unused tile (a sure sign of a tie). 
     * Checking for a tie when each player is "perfect", that is using the optimal move which 
     * guarantees the best chance of a win, is futile, as TicTacToe is a deterministic game
     * (as I discovered after googling it). Maybe a cool extension assignment would be to 
     * simulate games and graph the length of each game based on different starting moves, like a game tree.
     */
    public boolean checkTie() {
        int matches = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == "-") {
                    matches++;
                }
            }
        }
        return matches < 2;
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

/*
 * these are the aforementioned custom exceptions for the takeTurn method.
 * Turns out implementing your own exceptions is really easy, because
 * `Exception` is just an class, so you can extend it into a subclass and
 * use it with no fuss.
 */
class GameHasTiedException extends Exception {
    public GameHasTiedException() {
        super();
    }
}

class InvalidPositionException extends Exception {
    public InvalidPositionException() {
        super();
    }
}

class GameIsWonException extends Exception {
    public GameIsWonException() {
        super();
    }
}