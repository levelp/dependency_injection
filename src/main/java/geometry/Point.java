package geometry;

/**
 * Точка
 */
public class Point {
    private String name;
    private double x, y;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s %s  %s", name, x, y);
    }
}
