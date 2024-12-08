package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;

@FunctionalInterface
public interface Transformation {
    Point apply(Point p);
}
