package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;

public class Bubble implements Transformation {

    @Override
    public Point apply(Point p) {
        double r2 = p.x() * p.x() + p.y() * p.y();
        double newX = p.x() / (r2 + 1);
        double newY = p.y() / (r2 + 1);
        return new Point(newX, newY);
    }
}
