package backend.academy.fractal.renderer;

import backend.academy.fractal.domain.Point;
import backend.academy.fractal.domain.Rect;
import backend.academy.fractal.transformations.Transformation;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RendererConfigTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Rect worldBounds = new Rect(0, 0, 100, 100);
        List<Transformation> transformations = List.of(p -> new Point(p.x() + 1, p.y() + 1));

        // Act
        RendererConfig config = new RendererConfig(1920, 1080, 4, 10,
            worldBounds, transformations);

        // Assert
        assertEquals(1920, config.width());
        assertEquals(1080, config.height());
        assertEquals(4, config.samples());
        assertEquals(10, config.iterationsPerSample());
        assertEquals(worldBounds, config.worldBounds());
        assertEquals(transformations, config.transformations());
    }

    @Test
    void testToString() {
        // Arrange
        Rect worldBounds = new Rect(0, 0, 100, 100);
        List<Transformation> transformations = List.of(p -> new Point(p.x() + 1, p.y() + 1));
        RendererConfig config = new RendererConfig(1920, 1080, 4, 10,
            worldBounds, transformations);

        // Act
        String result = config.toString();

        // Assert
        assertTrue(result.contains("width=1920"));
        assertTrue(result.contains("height=1080"));
        assertTrue(result.contains("samples=4"));
        assertTrue(result.contains("iterationsPerSample=10"));
        assertTrue(result.contains("worldBounds=" + worldBounds.toString()));
        assertTrue(result.contains("transformations=" + transformations.toString()));
    }

    @Test
    void testDefaultColor() {
        // Act
        Color defaultColor = RendererConfig.DEFAULT_COLOR;

        // Assert
        assertEquals(255, defaultColor.getRed());
        assertEquals(128, defaultColor.getGreen());
        assertEquals(64, defaultColor.getBlue());
    }

    @Test
    void testColorShifts() {
        // Act
        int redShift = RendererConfig.RED_SHIFT;
        int greenShift = RendererConfig.GREEN_SHIFT;

        // Assert
        assertEquals(16, redShift);
        assertEquals(8, greenShift);
    }

    @Test
    void testEmptyTransformationsList() {
        // Arrange
        Rect worldBounds = new Rect(0, 0, 100, 100);
        List<Transformation> emptyTransformations = List.of();

        // Act
        RendererConfig config = new RendererConfig(1920, 1080, 4, 10,
            worldBounds, emptyTransformations);

        // Assert
        assertTrue(config.transformations().isEmpty());
    }

    @Test
    void testSingleTransformation() {
        // Arrange
        Rect worldBounds = new Rect(0, 0, 100, 100);
        Transformation transformation = p -> new Point(p.x() * 2, p.y() * 2);
        List<Transformation> transformations = List.of(transformation);

        // Act
        RendererConfig config = new RendererConfig(1920, 1080, 4, 10,
            worldBounds, transformations);

        // Assert
        assertEquals(1, config.transformations().size());
        assertEquals(transformation, config.transformations().getFirst());
    }
}
