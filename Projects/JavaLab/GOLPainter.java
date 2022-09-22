import java.lang.Math;

public class GOLPainter extends PainterPlus {
    public GOLPainter() {
        super();
    }
    static int gridSize = 32;
    static boolean[][] Tiles = new boolean[gridSize][gridSize];

    public void generateWorld() {

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
        for (int i = 0; i < Tiles.length; i++) {
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
         * each neighboring tile (e.g., a-1, b-1 --> which references position 1.)
         * 
         * This allows us to look up each row of the matrix by index, since 
         * java does not inherently create key/value pairs for each element in an
         * array.
        */
        for (int i = 0; i < check.length; i++) {
            int[] v = check[i];

            /*
             * This first checks to see if the selected cell is in the bounds of our
             * matrix (and by extension, our 32x32 grid which the GOLPainter moves in). 
             * Then, the if statement, for each position around the selected 
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
        
        //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
        if (Tiles[a][b] && numNeighbors < 2) {
            Tiles[a][b] = false;
            scrapePaint();
        }

        //Any live cell with two or three live neighbours lives on to the next generation.
        if (Tiles[a][b] && (numNeighbors == 2 || numNeighbors == 3)) {
            Tiles[a][b] = true;
        }

        //Any live cell with more than three live neighbours dies, as if by overpopulation.
        if (Tiles[a][b] && numNeighbors > 3) {
            Tiles[a][b] = false;
            scrapePaint();
        }

        //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        if (!Tiles[a][b] && numNeighbors == 3) {
            Tiles[a][b] = true;
            paint("white");
        }
    }

    public void traverseTiles() {
        int x = 0;
        int y = 0;
        
        // this nested for loop acts as our entire movement procedure throughout the grid.
        for (int i = 0; i < (gridSize - 1); i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                updateTile(x, y);
                move();
    
                if (getDirection() == "east") {
                    x++;
                }
                if (getDirection() == "west") {
                    x--;
                }
            }

            // This is for when the painter hits an edge of the grid
            if (getDirection() == "west") {
                updateTile(x, y);
                turnLeft();
                move();
                y++;
                updateTile(x, y);
                turnLeft();
            } else {
                updateTile(x, y);
                turnRight();
                move();
                y++;
                updateTile(x, y);
                turnRight();
            }
        }

        //This is our "cleanup" stage, where the painter reaches the end of the grid's tiles and needs to reset for another cycle.
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                move();
            }
            turnRight();
        }
    }

    /* This method is for "seeding" the random selection of "alive" tiles in generateWorld(). Here, the painter does basically the
     * same thing as in traverseTiles(), but doesn't update the tiles it is on.
     */
    public void seedTiles() {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < (gridSize - 1); i++) {
            for (int j = 0; j < (gridSize - 1); j++) {
                if (Tiles[x][y]) {
                    paint("white");
                }
                move();
    
                if (getDirection() == "east") {
                    x++;
                }

                if (getDirection() == "west") {
                    x--;
                }
            }

            if (getDirection() == "west") {
                turnLeft();
                move();
                y++;

                if (Tiles[x][y]) {
                    paint("white");
                }
                turnLeft();
            } else {
                turnRight();
                move();
                y++;

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