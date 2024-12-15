package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SwirlTest {
    @Test
    void testSwirlAtOrigin() {
        // Arrange
        Transformation swirl = new Swirl();
        Point original = new Point(0, 0);

        // Act
        Point result = swirl.apply(original);

        // Assert
        assertEquals(0, result.x(), 0.0001);  // Ожидаем (0, 0) для центра
        assertEquals(0, result.y(), 0.0001);  // Ожидаем (0, 0) для центра
    }

    @Test
    void testSwirlPositiveCoordinates() {
        // Arrange
        Transformation swirl = new Swirl();
        Point original = new Point(1, 1);

        // Act
        Point result = swirl.apply(original);

        // Assert
        assertNotEquals(original.x(), result.x());
        assertNotEquals(original.y(), result.y());
    }

    @Test
    void testSwirlNegativeCoordinates() {
        // Arrange
        Transformation swirl = new Swirl();
        Point original = new Point(-1, -1);

        // Act
        Point result = swirl.apply(original);

        // Assert
        assertNotEquals(original.x(), result.x());
        assertNotEquals(original.y(), result.y());
    }

    @Test
    void testSwirlAtUnitCircle() {
        // Arrange
        Transformation swirl = new Swirl();
        Point original = new Point(Math.cos(Math.PI / 4), Math.sin(Math.PI / 4));

        // Act
        Point result = swirl.apply(original);

        // Assert
        assertNotEquals(original.x(), result.x());
        assertNotEquals(original.y(), result.y());
    }

    @Test
    void testSwirlWithZeroCoordinates() {
        // Arrange
        Transformation swirl = new Swirl();
        Point original = new Point(0, 5); // На оси Y

        // Act
        Point result = swirl.apply(original);

        // Assert
        assertNotEquals(original.x(), result.x());
        assertNotEquals(original.y(), result.y());
    }
}
