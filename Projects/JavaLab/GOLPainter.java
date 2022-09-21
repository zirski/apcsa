import java.util.*;
import javax.swing.Painter;
import java.lang.Math;

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

        int min = 0;
        int max = (gridSize - 1);
        //assigns true to numTiles (which in this case is 32) random tiles
        for (int i = 0; i < numTiles; i++) {
            int randomTileX = (int)(Math.random()*(max - min + 1) + min);
            int randomTileY = (int)(Math.random()*(max - min + 1) + min);

            Tiles[randomTileX][randomTileY] = true;
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

            if (v[0] >= 0 && v[0] < gridSize && v[1] >= 0 && v[1] < gridSize ) {
                if (Tiles[v[0]][v[1]]) {
                    numNeighbors++;
                }
            }

        }

        //below are the four rules to the Game of Life (from wikipedia).
        if (Tiles[a][b] && numNeighbors < 2) {
            Tiles[a][b] = false;
            if (isOnPaint()) {
                scrapePaint();
            }
        }

        if (Tiles[a][b] && (numNeighbors == 2 || numNeighbors == 3)) {
            Tiles[a][b] = true;
            paint("white");
        }

        if (Tiles[a][b] && numNeighbors > 3) {
            Tiles[a][b] = false;

            if (isOnPaint()) {
                scrapePaint();
            }
        }

        if (!Tiles[a][b] && numNeighbors == 3) {
            Tiles[a][b] = true;
            paint("white");
        }

    }

    public void traverseTiles() {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < (gridSize - 1); i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                updateTile(x, y);
                move();
    
                if (getDirection() == "north") {
                    y--;
                }
                if (getDirection() == "east") {
                    x++;
                }
                if (getDirection() == "south") {
                    y++;
                }
                if (getDirection() == "west") {
                    x--;
                }
                
            }

            if (getDirection() == "west") {
                turnLeft();
                move();
                turnLeft();
            } else {
                turnRight();
                move();
                turnRight();
            }
            
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                move();
            }
            turnRight();
        }

        
    }

    public void seedTiles() {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < (gridSize - 1); i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                if (Tiles[x][y]) {
                    paint("white");
                }
                move();
    
                if (getDirection() == "north") {
                    y--;
                }
                if (getDirection() == "east") {
                    x++;
                }
                if (getDirection() == "south") {
                    y++;
                }
                if (getDirection() == "west") {
                    x--;
                }
            }

            if (getDirection() == "west") {
                turnLeft();
                move();
                if (Tiles[x][y]) {
                    paint("white");
                }
                turnLeft();
            } else {
                turnRight();
                move();
                if (Tiles[x][y]) {
                    paint("white");
                }
                turnRight();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                move();
            }
            turnRight();
        }
    }
}