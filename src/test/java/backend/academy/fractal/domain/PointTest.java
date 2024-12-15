package backend.academy.fractal.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testPointCreation() {
        // Arrange
        double x = 5.0;
        double y = 10.0;

        // Act
        Point point = new Point(x, y);

        // Assert
        assertEquals(x, point.x());
        assertEquals(y, point.y());
    }

    @Test
    void testPointEquality() {
        // Arrange
        Point point1 = new Point(5.0, 10.0);
        Point point2 = new Point(5.0, 10.0);

        // Act & Assert
        assertEquals(point1, point2);
    }

    @Test
    void testPointInequality() {
        // Arrange
        Point point1 = new Point(5.0, 10.0);
        Point point2 = new Point(10.0, 5.0);

        // Act & Assert
        assertNotEquals(point1, point2);
    }

    @Test
    void testPointCoordinates() {
        // Arrange
        Point point = new Point(3.0, 4.0);

        // Act & Assert
        assertEquals(3.0, point.x());
        assertEquals(4.0, point.y());
    }
}
