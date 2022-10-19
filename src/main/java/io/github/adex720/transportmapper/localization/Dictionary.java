package io.github.adex720.transportmapper.localization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adex720
 */
public class Dictionary {

    private final HashMap<String, String> TRANSLATIONS;

    public Dictionary(String name, JsonObject translations, Logger logger) {
        TRANSLATIONS = new HashMap<>();

        loadTranslations(name, translations, logger);
    }

    private void loadTranslations(String name, JsonObject json, Logger logger) {
        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            try {
                TRANSLATIONS.put(entry.getKey(), entry.getValue().getAsString());
            } catch (UnsupportedOperationException e) {
                logger.error("Exception during loading of language {}, Invalid value on key {}: Expected String, found: {}", name, entry.getKey(), entry.getValue().toString());
            }
        }
    }

    public String get(String key) {
        return TRANSLATIONS.get(key);
    }

    public String get(String key, Object... args) {
        return get(key).formatted(args);
    }
}
