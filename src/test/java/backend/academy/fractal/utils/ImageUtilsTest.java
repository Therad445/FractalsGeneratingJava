package backend.academy.fractal.utils;

import backend.academy.fractal.domain.FractalImage;
import backend.academy.fractal.domain.Pixel;
import backend.academy.fractal.renderer.RendererConfig;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ImageUtilsTest {

    @Test
    void testSaveImageIOException() throws IOException {
        // Arrange
        int width = 3;
        int height = 3;
        FractalImage image = FractalImage.create(width, height);
        Pixel pixel = new Pixel(100, 150, 200, 5);
        image.updatePixel(1, 1, pixel);

        // Mocking static method
        try (MockedStatic<ImageIO> mockedImageIO = mockStatic(ImageIO.class)) {
            mockedImageIO.when(() -> ImageIO.write(Mockito.any(BufferedImage.class), Mockito.anyString(), Mockito.any(File.class)))
                .thenThrow(new IOException());

            // Act & Assert
            assertThrows(IOException.class, () -> ImageUtils.save(image, "test.png"));
        }
    }

}
