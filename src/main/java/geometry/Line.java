package geometry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Линия
 */
public class Line {
    @Autowired
    @Qualifier("pointA")
    Point A;

    @Autowired
    @Qualifier("pointB")
    Point B;

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    @Override
    public String toString() {
        return "Line " + A + " - " + B;
    }
}
