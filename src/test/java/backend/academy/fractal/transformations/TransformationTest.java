package backend.academy.fractal.transformations;

import backend.academy.fractal.domain.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformationTest {

    @Test
    void testTranslation() {
        // Arrange
        Transformation translate = p -> new Point(p.x() + 5, p.y() + 10);
        Point original = new Point(1, 2);

        // Act
        Point result = translate.apply(original);

        // Assert
        assertEquals(6, result.x());
        assertEquals(12, result.y());
    }

    @Test
    void testScaling() {
        // Arrange
        Transformation scale = p -> new Point(p.x() * 2, p.y() * 3);
        Point original = new Point(2, 3);

        // Act
        Point result = scale.apply(original);

        // Assert
        assertEquals(4, result.x());
        assertEquals(9, result.y());
    }

    @Test
    void testIdentityTransformation() {
        // Arrange
        Transformation identity = p -> new Point(p.x(), p.y());
        Point original = new Point(4, 5);

        // Act
        Point result = identity.apply(original);

        // Assert
        assertEquals(4, result.x());
        assertEquals(5, result.y());
    }

    @Test
    void testTransformationWithNegativeCoordinates() {
        // Arrange
        Transformation translate = p -> new Point(p.x() - 3, p.y() - 7); // Сдвиг на (-3, -7)
        Point original = new Point(-1, -2);

        // Act
        Point result = translate.apply(original);

        // Assert
        assertEquals(-4, result.x());
        assertEquals(-9, result.y());
    }

    @Test
    void testScalingWithZero() {
        // Arrange
        Transformation scale = p -> new Point(p.x() * 0, p.y() * 0);
        Point original = new Point(5, 6);

        // Act
        Point result = scale.apply(original);

        // Assert
        assertEquals(0, result.x());
        assertEquals(0, result.y());
    }
}
