package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;

public class Spherical implements Transformation {

    @Override
    public Point apply(Point p) {
        double rSquared = p.x() * p.x() + p.y() * p.y();
        if (rSquared == 0) {
            return new Point(0, 0);
        }
        double newX = p.x() / rSquared;
        double newY = p.y() / rSquared;
        return new Point(newX, newY);
    }
}
