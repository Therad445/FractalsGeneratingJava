package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;

public class Swirl implements Transformation {

    @Override
    public Point apply(Point p) {
        double r2 = p.x() * p.x() + p.y() * p.y();
        double newX = p.x() * Math.sin(r2) - p.y() * Math.cos(r2);
        double newY = p.x() * Math.cos(r2) + p.y() * Math.sin(r2);
        return new Point(newX, newY);
    }
}
