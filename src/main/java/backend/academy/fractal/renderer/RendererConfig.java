package backend.academy.fractal.renderer;

import backend.academy.fractal.domain.Rect;
import backend.academy.fractal.transformations.Transformation;
import java.awt.Color;
import java.util.List;

public record RendererConfig(int width, int height, int samples, int iterationsPerSample, Rect worldBounds,
                             List<Transformation> transformations) {

    @Override
    public String toString() {
        return "RendererConfig{"
            + "width=" + width
            + ", height=" + height
            + ", samples=" + samples + ", iterationsPerSample=" + iterationsPerSample
            + ", worldBounds=" + worldBounds
            + ", transformations=" + transformations
            + '}';
    }

    public static final Color DEFAULT_COLOR = new Color(255, 128, 64);
    public static final int RED_SHIFT = 16;
    public static final int GREEN_SHIFT = 8;
}
