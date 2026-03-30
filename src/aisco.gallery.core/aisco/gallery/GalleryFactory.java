package aisco.gallery;

import aisco.gallery.core.Gallery;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class GalleryFactory {
    private static final Logger LOGGER = Logger.getLogger(GalleryFactory.class.getName());

    public GalleryFactory() {}

    public static Gallery createGallery(String fullyQualifiedName, Object... base) {
        Gallery record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (Gallery) constructor.newInstance(base);
        }
        catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of Gallery.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e) {
            LOGGER.severe("Failed to create instance of Gallery.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e) {
            LOGGER.severe("Failed to create instance of Gallery.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Class not found");
            System.exit(40);
        }
        catch (Exception e) {
            LOGGER.severe("Failed to create instance of Gallery.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }
}
