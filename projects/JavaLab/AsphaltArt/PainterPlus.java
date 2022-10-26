import org.code.neighborhood.Painter;

public class PainterPlus extends Painter {

  
  public PainterPlus() {
    super();
  }
  
  public void turnRight() {
    turnLeft();
    turnLeft();
    turnLeft();
  } 
  
  public void takeAllPaint() {
    while(isOnBucket()) {
      takePaint();
    }
  }
  
  public void paintLine(String Color) {
    while(hasPaint() && canMove()) {
      paint(Color);
      move();
    }
  }
  
  public void moveOrTakeAllPaint() {
    while(canMove()) {
      if (!isOnBucket()) {
        move();
      } else {
        takeAllPaint();
      }
    }
  }
  
  public void moveSouth() {
    if (canMove("south")) {
      if(isFacingSouth()) {
        move();
      } else {
        turnRight();
        move();
      }
    }
  }
  
  public void printStatus() {
    System.out.println("X: " + getX());
    
    System.out.println("Y: " + getY());
    
    System.out.println("Paint: " + getMyPaint());
    
    System.out.println("Facing: " + getDirection());
    
    
  }
  public static int gridSize = 32;
  public static boolean[][] Tiles = new boolean[gridSize][gridSize];
  
  public void generateWorld() {
    
    //creating a matrix of booleans; the boolean for each tile acts as our "is alive" state
    for (int i = 0; i < Tiles.length; i++) {
      for (int j = 0; j < Tiles.length; j++) {
        //this adds a boolean for each tile in the matrix (the "grid" in Java lab)
        Tiles[i][j] = false;
      }
    }

    int numStartingTiles = 60;
    int min = 0;
    int max = (gridSize - 1);
    //assigns true to a random selection of tiles; we can change the number of starting "alive" tiles using numTiles.
    for (int i = 0; i < numStartingTiles; i++) {
      int randomTileX = (int)(Math.random()*(max - min + 1) + min);
      int randomTileY = (int)(Math.random()*(max - min + 1) + min);

      Tiles[randomTileX][randomTileY] = true;
    }
  }
}
