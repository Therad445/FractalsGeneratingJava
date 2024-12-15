package backend.academy.fractal.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelTest {

    @Test
    void testPixelCreation() {
        // Arrange
        int r = 100;
        int g = 150;
        int b = 200;
        int hitCount = 5;

        // Act
        Pixel pixel = new Pixel(r, g, b, hitCount);

        // Assert
        assertEquals(r, pixel.r());
        assertEquals(g, pixel.g());
        assertEquals(b, pixel.b());
        assertEquals(hitCount, pixel.hitCount());
    }

    @Test
    void testAddPixels() {
        // Arrange
        Pixel pixel1 = new Pixel(100, 150, 200, 5);
        Pixel pixel2 = new Pixel(50, 50, 50, 3);

        // Act
        Pixel result = pixel1.add(pixel2);

        // Assert
        assertEquals(150, result.r());
        assertEquals(200, result.g());
        assertEquals(250, result.b());
        assertEquals(8, result.hitCount());
    }

    @Test
    void testAddPixelsWithRGBOverflow() {
        // Arrange
        Pixel pixel1 = new Pixel(100, 200, 150, 5);
        Pixel pixel2 = new Pixel(200, 100, 150, 3);

        // Act
        Pixel result = pixel1.add(pixel2);

        // Assert
        assertEquals(255, result.r());  // RGB overflow test
        assertEquals(255, result.g());  // RGB overflow test
        assertEquals(255, result.b());  // RGB overflow test
        assertEquals(8, result.hitCount());
    }

    @Test
    void testAddPixelsWithZero() {
        // Arrange
        Pixel pixel1 = new Pixel(0, 0, 0, 0);
        Pixel pixel2 = new Pixel(100, 150, 200, 5);

        // Act
        Pixel result = pixel1.add(pixel2);

        // Assert
        assertEquals(100, result.r());
        assertEquals(150, result.g());
        assertEquals(200, result.b());
        assertEquals(5, result.hitCount());
    }
}
