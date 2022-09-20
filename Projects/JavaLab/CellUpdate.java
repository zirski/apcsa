import java.util.*;

import javafx.util.Pair;

public class CellUpdate {
    
    public static void generateWorld() {
        int gridSize = 32;
        int numTiles = gridSize;
        boolean[][] Tiles = new boolean[gridSize][gridSize];

        //creating a matrix of booleans; the boolean for each tile acts as our "isAlive" state
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles.length; j++) {
                //this adds a boolean for each tile in the matrix (the "grid" in Java lab)
                Tiles[i][j] = false;
            }
        }
        Random random = new Random();

        int randomTile = random.nextInt(32);
        //assigns true to numTiles (which in this case is 32) random tiles
        for (int i = 0; i < numTiles; i++) {
            for (int j = 0; j < numTiles; j++) {
                Tiles[randomTile][randomTile] = true;
            }
        }
    }

    public static void updateTile(int a, int b) {
        
        Pair[] check = {
            
            /* Position grid (# refers to the current tile)
            *
            *   1   2   3
            *   4   #   5
            *   6   7   8
            */
            {3, 4},
            {a - 1, b - 1},  //Pos 1
            {x = a, y = b - 1},      //Pos 2
            {x = a + 1, y = b - 1},  //Pos 3
            
            {x = a - 1, y = b},      //Pos 4
            {x = a + 1, y = b},      //Pos 5
            
            {x = a - 1, y = b + 1},  //Pos 6
            {x = a, y = b + 1},      //Pos 7
            {x = a + 1, y = b + 1},  //Pos 8
        };

        int numNeighbors = 0;

    }
}


