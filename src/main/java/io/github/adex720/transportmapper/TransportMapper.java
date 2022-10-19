package io.github.adex720.transportmapper;

import io.github.adex720.transportmapper.localization.Translator;
import io.github.adex720.transportmapper.util.ResourceLoader;
import io.github.adex720.transportmapper.visual.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adex720
 */
public class TransportMapper {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TransportMapper.class);
        ResourceLoader resourceLoader = new ResourceLoader(logger);

        Translator translator = new Translator("en_uk", resourceLoader, logger);

        Frame frame = new Frame(logger, translator);
    }


}
