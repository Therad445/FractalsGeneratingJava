package backend.academy.fractal.domain;

public record Pixel(int r, int g, int b, int hitCount) {
    private static final int RGB_INT = 255;

    public Pixel add(Pixel other) {
        return new Pixel(
            Math.min(RGB_INT, r + other.r),
            Math.min(RGB_INT, g + other.g),
            Math.min(RGB_INT, b + other.b),
            hitCount + other.hitCount
        );
    }
}
