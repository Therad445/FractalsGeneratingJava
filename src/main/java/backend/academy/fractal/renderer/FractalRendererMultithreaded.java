package backend.academy.fractal.renderer;

import backend.academy.fractal.domain.FractalImage;
import backend.academy.fractal.domain.Pixel;
import backend.academy.fractal.domain.Point;
import backend.academy.fractal.domain.Rect;
import backend.academy.fractal.transformations.Transformation;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class FractalRendererMultithreaded {

    private static final ForkJoinPool POOL = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public static void render(
        FractalImage canvas,
        Rect world,
        List<Transformation> transformations,
        int samples,
        int iterPerSample
    ) {
        POOL.invoke(new RenderTask(canvas, world, transformations, samples, iterPerSample, 0, samples));
    }

    private static class RenderTask extends RecursiveAction {
        private static final int THRESHOLD = 10_000;  // Увеличенный порог
        private final FractalImage canvas;
        private final Rect world;
        private final List<Transformation> transformations;
        private final int samples;
        private final int iterPerSample;
        private final int start;
        private final int end;

        RenderTask(FractalImage canvas, Rect world, List<Transformation> transformations, int samples, int iterPerSample, int start, int end) {
            this.canvas = canvas;
            this.world = world;
            this.transformations = transformations;
            this.samples = samples;
            this.iterPerSample = iterPerSample;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                renderPart();
            } else {
                int mid = (start + end) / 2;
                invokeAll(
                    new RenderTask(canvas, world, transformations, samples, iterPerSample, start, mid),
                    new RenderTask(canvas, world, transformations, samples, iterPerSample, mid, end)
                );
            }
        }

        private void renderPart() {
            ThreadLocalRandom rand = ThreadLocalRandom.current();

            int[][] pixelBuffer = new int[canvas.width()][canvas.height()];

            for (int i = start; i < end; i++) {
                Point p = new Point(rand.nextDouble(world.x(), world.x() + world.width()),
                    rand.nextDouble(world.y(), world.y() + world.height()));

                for (int j = 0; j < iterPerSample; j++) {
                    Transformation transformation = transformations.get(rand.nextInt(transformations.size()));
                    p = transformation.apply(p);

                    if (world.contains(p)) {
                        int x = (int) ((p.x() - world.x()) / world.width() * canvas.width());
                        int y = (int) ((p.y() - world.y()) / world.height() * canvas.height());

                        if (pixelBuffer[x][y] == 0) {
                            pixelBuffer[x][y] = 1;
                        } else {
                            pixelBuffer[x][y]++;
                        }
                    }
                }
            }

            for (int x = 0; x < canvas.width(); x++) {
                for (int y = 0; y < canvas.height(); y++) {
                    if (pixelBuffer[x][y] > 0) {
                        canvas.updatePixel(x, y, new Pixel(RendererConfig.DEFAULT_COLOR.getRed(),
                            RendererConfig.DEFAULT_COLOR.getGreen(), RendererConfig.DEFAULT_COLOR.getBlue(), 255));
                    }
                }
            }
        }
    }
}
