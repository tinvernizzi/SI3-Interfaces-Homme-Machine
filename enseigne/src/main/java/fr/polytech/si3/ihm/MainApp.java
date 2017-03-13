package fr.polytech.si3.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    private static boolean adminMode = false;

    public static void main(String[] args) throws Exception {

        for (String arg : args)
                adminMode = arg.equals("-admin") || adminMode;

        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting enseigne application");

        String fxmlFile = (adminMode ? "/fxml/admin_home.fxml" : "/fxml/home.fxml");

        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 1020, 700);
        //scene.getStylesheets().add("");

        stage.setTitle("To Be Or To Have - Enseigne Application");
        stage.setScene(scene);
        stage.show();
    }
}
