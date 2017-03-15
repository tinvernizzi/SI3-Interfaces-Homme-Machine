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

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting Mall application");

        String fxmlFile = "/fxml/homePage.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode, 1000, 700);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Page d'acceuil - Cap Sophia");
        stage.setScene(scene);
        stage.show();
    }
}
