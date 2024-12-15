package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinusoidalTest {

    @Test
    void testSinusoidalAtOrigin() {
        // Arrange
        Transformation sinusoidal = new Sinusoidal();
        Point original = new Point(0, 0);

        // Act
        Point result = sinusoidal.apply(original);

        // Assert
        assertEquals(0, result.x(), 0.0001);
        assertEquals(0, result.y(), 0.0001);
    }

    @Test
    void testSinusoidalWithPositiveCoordinates() {
        // Arrange
        Transformation sinusoidal = new Sinusoidal();
        Point original = new Point(Math.PI / 2, Math.PI / 2);

        // Act
        Point result = sinusoidal.apply(original);

        // Assert
        assertEquals(1, result.x(), 0.0001);
        assertEquals(1, result.y(), 0.0001);
    }

    @Test
    void testSinusoidalWithNegativeCoordinates() {
        // Arrange
        Transformation sinusoidal = new Sinusoidal();
        Point original = new Point(-Math.PI / 2, -Math.PI / 2);

        // Act
        Point result = sinusoidal.apply(original);

        // Assert
        assertEquals(-1, result.x(), 0.0001);
        assertEquals(-1, result.y(), 0.0001);
    }

    @Test
    void testSinusoidalWithZero() {
        // Arrange
        Transformation sinusoidal = new Sinusoidal();
        Point original = new Point(0, Math.PI);

        // Act
        Point result = sinusoidal.apply(original);

        // Assert
        assertEquals(0, result.x(), 0.0001);
        assertEquals(0, result.y(), 0.0001);
    }

    @Test
    void testSinusoidalWithLargeCoordinates() {
        // Arrange
        Transformation sinusoidal = new Sinusoidal();
        Point original = new Point(10, 15);

        // Act
        Point result = sinusoidal.apply(original);

        // Assert
        assertNotEquals(original.x(), result.x());
        assertNotEquals(original.y(), result.y());
    }
}
