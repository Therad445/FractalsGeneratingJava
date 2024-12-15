package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearTest {
    @Test
    void testLinearAtOrigin() {
        // Arrange
        Transformation linear = new Linear();
        Point original = new Point(0, 0);

        // Act
        Point result = linear.apply(original);

        // Assert
        assertEquals(0, result.x(), 0.0001);
        assertEquals(0, result.y(), 0.0001);
    }

    @Test
    void testLinearWithPositiveCoordinates() {
        // Arrange
        Transformation linear = new Linear();
        Point original = new Point(2, 3);

        // Act
        Point result = linear.apply(original);

        // Assert
        assertEquals(2, result.x(), 0.0001);
        assertEquals(3, result.y(), 0.0001);
    }

    @Test
    void testLinearWithNegativeCoordinates() {
        // Arrange
        Transformation linear = new Linear();
        Point original = new Point(-5, -7);

        // Act
        Point result = linear.apply(original);

        // Assert
        assertEquals(-5, result.x(), 0.0001);
        assertEquals(-7, result.y(), 0.0001);
    }

    @Test
    void testLinearWithMixedCoordinates() {
        // Arrange
        Transformation linear = new Linear();
        Point original = new Point(-3, 6);

        // Act
        Point result = linear.apply(original);

        // Assert
        assertEquals(-3, result.x(), 0.0001);
        assertEquals(6, result.y(), 0.0001);
    }

    @Test
    void testLinearWithLargeCoordinates() {
        // Arrange
        Transformation linear = new Linear();
        Point original = new Point(1000, 2000);

        // Act
        Point result = linear.apply(original);

        // Assert
        assertEquals(1000, result.x(), 0.0001);
        assertEquals(2000, result.y(), 0.0001);
    }
}
