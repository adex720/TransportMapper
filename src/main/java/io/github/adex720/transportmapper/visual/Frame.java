package io.github.adex720.transportmapper.visual;

import io.github.adex720.transportmapper.localization.Translator;
import org.slf4j.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Adex720
 */
public class Frame extends JFrame {

    private final Logger logger;
    private final Translator translator;

    private final MapPanel mapPanel;

    public Frame(Logger logger, Translator translator) {
        this.logger = logger;
        this.translator = translator;

        mapPanel = new MapPanel();

        initFrameContent();
        initFrameProperties();
    }

    private void initFrameProperties() {
        setTitle(translator.get("window.title"));
        setSize(1000, 720);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onFrameClosed(e);
            }
        });
    }

    private void initFrameContent() {
        setJMenuBar(createMenuBar());
        add(mapPanel);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = createJMenu("File", KeyEvent.VK_F);
        file.add(createJMenuItem("New", KeyEvent.VK_N, "Open a new window for a new map"));
        file.add(createJMenuItem("Save", KeyEvent.VK_S, "Save the current file"));
        file.add(createJMenuItem("Save As", KeyEvent.VK_A, "Save the current file to a new location"));
        file.add(createJMenuItem("Export", KeyEvent.VK_E, "Export the map"));
        file.add(createJMenuItem("Print", KeyEvent.VK_P, "Print the map"));
        menuBar.add(file);

        JMenu view = createJMenu("View", KeyEvent.VK_V);
        menuBar.add(view);

        JMenu tools = createJMenu("Tools", KeyEvent.VK_T);
        menuBar.add(tools);

        JMenu help = createJMenu("Help", KeyEvent.VK_H);
        menuBar.add(help);

        return menuBar;
    }

    private JMenu createJMenu(String name, int mnemonic) {
        JMenu menu = new JMenu(name);
        menu.setMnemonic(mnemonic);
        return menu;
    }

    private JMenuItem createJMenuItem(String name, int mnemonic, String description) {
        JMenuItem menuItem = new JMenuItem(name, mnemonic);
        menuItem.getAccessibleContext().setAccessibleDescription(description);
        return menuItem;
    }

    private void openNew() {

    }

    private void onFrameClosed(WindowEvent event) {
        dispose();
    }
}
