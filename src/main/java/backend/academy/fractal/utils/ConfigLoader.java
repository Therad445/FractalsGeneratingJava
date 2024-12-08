package backend.academy.fractal.utils;

import java.io.IOException;
import java.util.Properties;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigLoader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(ConfigLoader.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки конфигурации", e);
        }
    }

    public static int getInt(String key) {
        return Integer.parseInt(PROPERTIES.getProperty(key));
    }

    public static double getDouble(String key) {
        return Double.parseDouble(PROPERTIES.getProperty(key));
    }
}
