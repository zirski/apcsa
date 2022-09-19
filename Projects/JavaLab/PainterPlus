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
}
