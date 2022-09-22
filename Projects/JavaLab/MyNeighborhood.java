import org.code.neighborhood.Painter;

public class MyNeighborhood {

  
  static GOLPainter myGOLPainter = new GOLPainter();

  public static void main(String[] args) {
    myGOLPainter.generateWorld();
    myGOLPainter.seedTiles();
    myGOLPainter.traverseTiles();
    
  }
}