package pl.sda.utils;

import java.io.IOException;
import java.util.Properties;

public class ApplicationPropertiesProvider {

    private static final Properties sql7573592Properties = loadProperties("/sql7573592.properties");

    private static Properties loadProperties(String resource) {
        final var properties = new Properties();

        try(final var propertiesInputStream = ApplicationPropertiesProvider.class.getResourceAsStream(resource)) {
            properties.load(propertiesInputStream);
        }
        catch(IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
        return properties;
    }

    private ApplicationPropertiesProvider() {
        throw new UnsupportedOperationException();
    }

    public static Properties getWorldProperties() {
        return sql7573592Properties;
    }


}
