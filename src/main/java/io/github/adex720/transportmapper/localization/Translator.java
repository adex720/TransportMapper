package io.github.adex720.transportmapper.localization;

import com.google.gson.JsonObject;
import io.github.adex720.transportmapper.util.ResourceLoader;
import org.slf4j.Logger;

/**
 * @author Adex720
 */
public class Translator {

    private static final String DEFAULT_LANGUAGE_NAME = "en_uk";

    private final Dictionary defaultLanguage;
    private Dictionary currentLanguage;

    private final Logger logger;

    public Translator(String language, ResourceLoader resourceLoader, Logger logger) {
        this.logger = logger;

        defaultLanguage = loadDictionary(resourceLoader, DEFAULT_LANGUAGE_NAME);
        if (language.equals(DEFAULT_LANGUAGE_NAME)) currentLanguage = null;
        else currentLanguage = loadDictionary(resourceLoader, language);
    }

    public String get(String key) {
        if (currentLanguage != null) {
            String translation = currentLanguage.get(key);
            if (translation != null) return translation;
        }
        String translation = defaultLanguage.get(key);
        if (translation != null) return translation;
        return key;
    }

    public Dictionary loadDictionary(ResourceLoader resourceLoader, String language) {
        logger.info("Loading language {}", language);
        JsonObject languageJson = resourceLoader.getJson(getLanguageFilePath(language)).getAsJsonObject();
        return new Dictionary(language, languageJson, logger);
    }

    public String getLanguageFilePath(String language) {
        return "lang/" + language + ".json";
    }

    public void updateLanguage(String language, ResourceLoader resourceLoader) {
        if (language.equals(DEFAULT_LANGUAGE_NAME)) currentLanguage = null;
        else currentLanguage = loadDictionary(resourceLoader, language);
    }
}
