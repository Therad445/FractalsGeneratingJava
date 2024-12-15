package backend.academy.fractal.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigLoaderTest {

    @Test
    void testGetIntWithInvalidKey() {
        // Arrange
        // В файле config.properties нет свойства invalidKey

        // Act & Assert
        assertThrows(NumberFormatException.class, () -> {
            ConfigLoader.getInt("invalidKey");
        });
    }
}
