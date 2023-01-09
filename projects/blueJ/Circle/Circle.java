public class Circle {
    private int radius;
    private String color;
    private int x;
    private int y;

    public Circle(int radius, String color, int x, int y) {
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return color + " circle with a radius of " + radius + " at position (" + x + ", " + y + ")";
    }

    public boolean equals(Circle other) {
        if (this.radius == other.radius && this.color == other.color && this.x == other.x && this.y == other.y) {
            return true;
        } else {
            return false;
        }
    }
}