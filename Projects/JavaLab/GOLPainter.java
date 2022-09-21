import java.util.*;
import javax.swing.Painter;

public class GOLPainter extends PainterPlus {
    public GOLPainter() {
        super();
    }
    
    static int gridSize = 32;
    static boolean[][] Tiles = new boolean[gridSize][gridSize];

    
    public void generateWorld() {
        int numTiles = gridSize;

        //creating a matrix of booleans; the boolean for each tile acts as our "isAlive" state
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles.length; j++) {
                //this adds a boolean for each tile in the matrix (the "grid" in Java lab)
                Tiles[i][j] = false;
            }
        }
        Random random = new Random();

        //assigns true to numTiles (which in this case is 32) random tiles
        for (int i = 0; i < numTiles; i++) {
            int randomTilex = random.nextInt(32);
            int randomTiley = random.nextInt(32);

            Tiles[randomTilex][randomTiley] = true;
        }
    }

    public void updateTile(int a, int b) {
        
        int[][] check = {
            /*
            * Position grid (# refers to the current tile)
            *   1   2   3
            *   4   #   5
            *   6   7   8
            */

            {a - 1, b - 1},  //Pos 1
            {a, b - 1},      //Pos 2
            {a + 1, b - 1},  //Pos 3
            {a - 1, b},      //Pos 4
            {a + 1, b},      //Pos 5
            {a - 1, b + 1},  //Pos 6
            {a, b + 1},      //Pos 7
            {a + 1, b + 1},  //Pos 8
        };

        int numNeighbors = 0;

        /*
         * this for loop, for each row in our "check" matrix, iterates through
         * each value. the array "v" only has two elements: the x and y coordinates for
         * each neighboring tile (a-1, b-1 --> which references position 1.)
         * 
         * This allows us to look up each column of the matrix by index, since 
         * java does not inherently create key/value pairs for each element in an
         * array.
        */
        for (int i = 0; i < check.length; i++) {
            int[] v = check[i];

            /*
             * This first checks to see if the selected cell is in the bounds of our
             * matrix. Then, the if statement, for each position around the selected 
             * tile (a, b), evaluates their "Tiles[i][j]" boolean and adds 1 to the 
             * "numNeighbors" counter based on such.
            */

            if (v[0] >= 1 && v[0] <= gridSize && v[1] >= 1 && v[1] <= gridSize ) {
                if (Tiles[v[0]][v[1]]) {
                    numNeighbors++;
                }
            }

        }

        //below are the four rules to the Game of Life (from wikipedia).
        if (Tiles[a][b] && numNeighbors < 2) {
            Tiles[a][b] = false;
        }

        if (Tiles[a][b] && (numNeighbors == 2 || numNeighbors == 3)) {
            Tiles[a][b] = true;
        }

        if (Tiles[a][b] && numNeighbors > 3) {
            Tiles[a][b] = false;
        }

        if (!Tiles[a][b] && numNeighbors == 3) {
            Tiles[a][b] = true;
        }

    }
}