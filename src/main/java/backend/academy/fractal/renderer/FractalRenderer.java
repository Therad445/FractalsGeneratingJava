package backend.academy.fractal.renderer;

import backend.academy.fractal.domain.FractalImage;
import backend.academy.fractal.domain.Pixel;
import backend.academy.fractal.domain.Point;
import backend.academy.fractal.domain.Rect;
import backend.academy.fractal.transformations.Transformation;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FractalRenderer {
    public static void render(
        FractalImage canvas,
        Rect world,
        List<Transformation> transformations,
        int samples,
        int iterPerSample
    ) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i < samples; i++) {
            Point p = new Point(rand.nextDouble(world.x(), world.x() + world.width()),
                rand.nextDouble(world.y(), world.y() + world.height()));

            for (int j = 0; j < iterPerSample; j++) {
                Transformation t = transformations.get(rand.nextInt(transformations.size()));
                p = t.apply(p);

                if (world.contains(p)) {
                    int x = (int) ((p.x() - world.x()) / world.width() * canvas.width());
                    int y = (int) ((p.y() - world.y()) / world.height() * canvas.height());

                    Pixel current = canvas.getPixel(x, y);
                    Color color = RendererConfig.DEFAULT_COLOR;
                    Pixel updated = new Pixel(color.getRed(), color.getGreen(), color.getBlue(),
                        current.hitCount() + 1);
                    canvas.updatePixel(x, y, current.add(updated));
                }
            }
        }
    }
}
