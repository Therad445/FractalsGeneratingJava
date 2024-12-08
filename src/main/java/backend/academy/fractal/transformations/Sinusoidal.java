package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;

public class Sinusoidal implements Transformation {
    @Override
    public Point apply(Point p) {
        return new Point(Math.sin(p.x()), Math.sin(p.y()));
    }
}
