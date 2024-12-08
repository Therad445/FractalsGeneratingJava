package backend.academy.fractal.utils;

import backend.academy.fractal.domain.FractalImage;
import backend.academy.fractal.renderer.RendererConfig;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ImageUtils {
    public static void save(FractalImage image, String filename) throws IOException {
        BufferedImage img = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                var pixel = image.getPixel(x, y);
                int color = (pixel.r() << RendererConfig.RED_SHIFT)
                    | (pixel.g() << RendererConfig.GREEN_SHIFT)
                    | pixel.b();
                img.setRGB(x, y, color);
            }
        }

        ImageIO.write(img, "png", new File(filename));
    }
}
