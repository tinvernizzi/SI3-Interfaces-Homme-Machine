package fr.polytech.si3.ihm;

import fr.polytech.si3.ihm.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    private static String styleSheet = "/styles/default.css";

    public static void main(String[] args) throws Exception {

        for (String arg : args)
                styleSheet = "/styles/" + arg + ".css";
        launch(args);
    }

    public static String getStyleSheet() {
        return styleSheet;
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting enseigne application");

        String fxmlFile = "/fxml/home.fxml";

        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add(styleSheet);

        stage.setTitle("To Be Or To Have - Enseigne Application");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
