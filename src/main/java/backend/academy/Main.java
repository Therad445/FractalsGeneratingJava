package backend.academy;

import backend.academy.fractal.domain.FractalImage;
import backend.academy.fractal.domain.Rect;
import backend.academy.fractal.renderer.FractalRenderer;
import backend.academy.fractal.renderer.RendererConfig;
import backend.academy.fractal.transformations.Bubble;
import backend.academy.fractal.transformations.Linear;
import backend.academy.fractal.transformations.Sinusoidal;
import backend.academy.fractal.transformations.Spherical;
import backend.academy.fractal.transformations.Swirl;
import backend.academy.fractal.utils.ConfigLoader;
import backend.academy.fractal.utils.ImageUtils;
import java.util.List;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class Main {
    public static void main(String[] args) {
        RendererConfig config = new RendererConfig(
            ConfigLoader.getInt("image.width"), ConfigLoader.getInt("image.height"),
            ConfigLoader.getInt("samples"), ConfigLoader.getInt("max.iterations"),
            new Rect(ConfigLoader.getDouble("world.x"), ConfigLoader.getDouble("world.y"),
                ConfigLoader.getDouble("world.width"), ConfigLoader.getDouble("world.height")),
            List.of(
                new Linear(),
                new Sinusoidal(),
                new Spherical(),
                new Swirl(),
                new Bubble()
            )
        );
        FractalImage canvas = FractalImage.create(config.width(), config.height());

        log.info("Генерация фрактального пламени...");
        FractalRenderer.render(
            canvas,
            config.worldBounds(),
            config.transformations(),
            config.samples(),
            config.iterationsPerSample()
        );

        try {
            ImageUtils.save(canvas, "fractal.png");
            log.info("Фрактал сохранен как fractal.png");
        } catch (Exception e) {
            log.error("Ошибка сохранения: {}", e.getMessage());
        }
    }
}
