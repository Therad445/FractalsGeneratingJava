package backend.academy;

import backend.academy.fractal.domain.FractalImage;
import backend.academy.fractal.domain.Rect;
import backend.academy.fractal.renderer.FractalRenderer;
import backend.academy.fractal.renderer.FractalRendererMultithreaded;
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

        long SingleThreadingStartTime = System.currentTimeMillis();
        FractalImage canvasSingle = FractalImage.create(config.width(), config.height());
        log.info("Генерация фрактального пламени...");
        FractalRenderer.render(
            canvasSingle,
            config.worldBounds(),
            config.transformations(),
            config.samples(),
            config.iterationsPerSample()
        );
        long SingleThreadingEndTime = System.currentTimeMillis();

        saveImage(canvasSingle, "fractalSingle.png");
        log.info("Рендеринг завершён за {} мс", SingleThreadingEndTime - SingleThreadingStartTime);

        FractalImage canvasMulti = FractalImage.create(config.width(), config.height());


        long MultiThreadingStartTime = System.currentTimeMillis();
        FractalRendererMultithreaded.render(
            canvasMulti,
            config.worldBounds(),
            config.transformations(),
            config.samples(),
            config.iterationsPerSample()
        );
        long MultiThreadingEndTime = System.currentTimeMillis();

        saveImage(canvasMulti, "fractalMulti.png");
        log.info("Рендеринг завершён за {} мс", MultiThreadingEndTime - MultiThreadingStartTime);

    }

    private static void saveImage(FractalImage canvasSingle, String image) {
        try {
            ImageUtils.save(canvasSingle, image);
            log.info("Фрактал сохранен как {}", image);
        } catch (Exception e) {
            log.error("Ошибка сохранения: {}", e.getMessage());
        }
    }
}
