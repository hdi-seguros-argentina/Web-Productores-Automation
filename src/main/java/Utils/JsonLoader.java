package Utils;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonLoader {

    public static <T> T load(String path, Class<T> clazz) {
        try (InputStream is = JsonLoader.class
                .getClassLoader()
                .getResourceAsStream(path);
             Reader reader = new InputStreamReader(is)) {

            return new Gson().fromJson(reader, clazz);

        } catch (Exception e) {
            throw new RuntimeException("Error cargando JSON: " + path, e);
        }
    }
}