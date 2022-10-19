package io.github.adex720.transportmapper.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.slf4j.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author adex720
 */
public class ResourceLoader {

    private final Gson gson;
    private final Logger logger;

    public ResourceLoader(Logger logger) {
        this.logger = logger;
        gson = new Gson();
    }

    public JsonElement getJson(String path) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        Reader reader = new InputStreamReader(inputStream);
        return gson.fromJson(reader, JsonElement.class);
    }

}
