package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;

public class Linear implements Transformation {
    @Override
    public Point apply(Point p) {
        return new Point(p.x(), p.y());
    }
}
