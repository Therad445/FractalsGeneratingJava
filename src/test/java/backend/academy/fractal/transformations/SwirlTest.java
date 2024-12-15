package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SwirlTest {
    @Test
    void testTransformationNonZeroPoint() {
        // Arrange
        Transformation spherical = new Spherical();
        Point original = new Point(2, 3);

        // Act
        Point result = spherical.apply(original);

        // Assert
        assertEquals(2.0 / 13, result.x());
        assertEquals(3.0 / 13, result.y());
    }

    @Test
    void testTransformationOrigin() {
        // Arrange
        Transformation spherical = new Spherical();
        Point original = new Point(0, 0);

        // Act
        Point result = spherical.apply(original);

        // Assert
        assertEquals(0, result.x());
        assertEquals(0, result.y());
    }

    @Test
    void testTransformationNegativeCoordinates() {
        // Arrange
        Transformation spherical = new Spherical();
        Point original = new Point(-2, -3);

        // Act
        Point result = spherical.apply(original);

        // Assert
        assertEquals(-2.0 / 13, result.x());
        assertEquals(-3.0 / 13, result.y());
    }

    @Test
    void testTransformationPointOnAxis() {
        // Arrange
        Transformation spherical = new Spherical();
        Point originalX = new Point(5, 0);
        Point originalY = new Point(0, 4);

        // Act
        Point resultX = spherical.apply(originalX);
        Point resultY = spherical.apply(originalY);

        // Assert
        assertEquals(1.0 / 5, resultX.x());
        assertEquals(0, resultX.y());

        assertEquals(0, resultY.x());
        assertEquals(1.0 / 4, resultY.y());
    }
}
