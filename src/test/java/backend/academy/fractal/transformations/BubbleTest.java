package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleTest {
    @Test
    void testBubbleAtOrigin() {
        // Arrange
        Transformation bubble = new Bubble();
        Point original = new Point(0, 0);

        // Act
        Point result = bubble.apply(original);

        // Assert
        assertEquals(0, result.x(), 0.0001);
        assertEquals(0, result.y(), 0.0001);
    }

    @Test
    void testBubbleWithPositiveCoordinates() {
        // Arrange
        Transformation bubble = new Bubble();
        Point original = new Point(1, 2);

        // Act
        Point result = bubble.apply(original);

        // Assert
        assertEquals(1.0 / 6, result.x(), 0.0001);
        assertEquals(2.0 / 6, result.y(), 0.0001);
    }

    @Test
    void testBubbleWithNegativeCoordinates() {
        // Arrange
        Transformation bubble = new Bubble();
        Point original = new Point(-1, -2);

        // Act
        Point result = bubble.apply(original);

        // Assert
        assertEquals(-1.0 / 6, result.x(), 0.0001);
        assertEquals(-2.0 / 6, result.y(), 0.0001);
    }

    @Test
    void testBubbleWithCoordinatesOnUnitCircle() {
        // Arrange
        Transformation bubble = new Bubble();
        Point original = new Point(1, 0);

        // Act
        Point result = bubble.apply(original);

        // Assert
        assertEquals(0.5, result.x(), 0.0001);
        assertEquals(0, result.y(), 0.0001);
    }

    @Test
    void testBubbleWithLargeCoordinates() {
        // Arrange
        Transformation bubble = new Bubble();
        Point original = new Point(10, 15);

        // Act
        Point result = bubble.apply(original);

        // Assert
        assertEquals(10.0 / 326, result.x(), 0.0001);
        assertEquals(15.0 / 326, result.y(), 0.0001);
    }
}
