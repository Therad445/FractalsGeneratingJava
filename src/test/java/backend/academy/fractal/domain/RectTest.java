package backend.academy.fractal.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectTest {

    @Test
    void testPointInsideRect() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point pointInside = new Point(5, 5);

        // Act
        boolean result = rect.contains(pointInside);

        // Assert
        assertTrue(result);
    }

    @Test
    void testPointOnLeftEdge() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point pointOnLeftEdge = new Point(0, 5);

        // Act
        boolean result = rect.contains(pointOnLeftEdge);

        // Assert
        assertTrue(result);
    }

    @Test
    void testPointOnRightEdge() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point pointOnRightEdge = new Point(10, 5);

        // Act
        boolean result = rect.contains(pointOnRightEdge);

        // Assert
        assertTrue(result);
    }

    @Test
    void testPointOnTopEdge() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point pointOnTopEdge = new Point(5, 0);

        // Act
        boolean result = rect.contains(pointOnTopEdge);

        // Assert
        assertTrue(result);
    }

    @Test
    void testPointOnBottomEdge() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point pointOnBottomEdge = new Point(5, 10);

        // Act
        boolean result = rect.contains(pointOnBottomEdge);

        // Assert
        assertTrue(result);
    }

    @Test
    void testPointOutsideRect() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point pointOutside = new Point(15, 15);

        // Act
        boolean result = rect.contains(pointOutside);

        // Assert
        assertFalse(result);
    }
}
