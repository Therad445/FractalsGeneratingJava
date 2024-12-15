package backend.academy.fractal.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractalImageTest {

    @Test
    void testCreateFractalImage() {
        // Arrange
        int width = 5;
        int height = 4;

        // Act
        FractalImage image = FractalImage.create(width, height);

        // Assert
        assertEquals(width, image.width());
        assertEquals(height, image.height());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                assertEquals(0, image.getPixel(x, y).r());
                assertEquals(0, image.getPixel(x, y).g());
                assertEquals(0, image.getPixel(x, y).b());
                assertEquals(0, image.getPixel(x, y).hitCount());
            }
        }
    }

    @Test
    void testGetPixel() {
        // Arrange
        int width = 3;
        int height = 3;
        FractalImage image = FractalImage.create(width, height);
        Pixel pixel = new Pixel(100, 150, 200, 5);
        image.updatePixel(1, 1, pixel);

        // Act
        Pixel result = image.getPixel(1, 1);

        // Assert
        assertEquals(pixel, result);
    }

    @Test
    void testUpdatePixel() {
        // Arrange
        int width = 3;
        int height = 3;
        FractalImage image = FractalImage.create(width, height);
        Pixel newPixel = new Pixel(255, 255, 255, 10);

        // Act
        image.updatePixel(2, 2, newPixel);
        Pixel result = image.getPixel(2, 2);

        // Assert
        assertEquals(newPixel, result);
    }

    @Test
    void testUpdatePixelOutOfBounds() {
        // Arrange
        int width = 3;
        int height = 3;
        FractalImage image = FractalImage.create(width, height);

        // Act & Assert
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> image.updatePixel(5, 5, new Pixel(100, 100, 100, 1)));
    }
}
