package io.github.adex720.transportmapper.visual;

import io.github.adex720.transportmapper.localization.Translator;
import org.slf4j.Logger;

import javax.swing.*;

/**
 * @author Adex720
 */
public class Frame extends JFrame {

    private final Logger logger;
    private final Translator translator;

    public Frame(Logger logger, Translator translator) {
        this.logger = logger;
        this.translator = translator;

        setTitle(translator.get("window.title"));
        setSize(1000, 720);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
