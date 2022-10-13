import org.code.neighborhood.Painter;

public class MyNeighborhood {

  static GOLPainter myGOLPainter = new GOLPainter();

  public static void main(String[] args) {
    myGOLPainter.generateWorld();
    myGOLPainter.seedTiles();

    for (int i = 0; i < 10; i++) {
      myGOLPainter.traverseTiles();
    }
  }
}