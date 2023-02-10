public class Chessboard
{
    public static void main(String[] args)
    {
        //Create an 8x8 2D String array called chess.
        String[][] chess = new String[8][8];

        for (int i = 2; i < chess.length - 2; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = "-";
            }
        }

        for (int i = 0; i < chess.length; i++) {
            chess[1][i] = "pawn";
            chess[chess.length - 2][i] = "pawn";
            
        }

        for (int i = 0; i < chess.length; i += chess.length - 1) {
            chess[i][0] = "rook";
            chess[i][1] = "knight";
            chess[i][2] = "bishop";
            chess[i][3] = "queen";
            chess[i][4] = "king";
            chess[i][5] = "bishop";
            chess[i][6] = "knight";
            chess[i][7] = "rook";
        }
        //Use this method to print the chess board onto the console
        print(chess);
    }
    
    //Do not make alterations to this method!
    public static void print(String[][] array)
    {
        for(String[] row: array)
        {
            for(String thing: row)
            {
                System.out.print(thing + "\t");
            }
            System.out.println();
        }
    }
}