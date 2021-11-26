package com.example.passwordstoragedb;
import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    static Logger logger = Logger.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.properties";
        logger.debug("this is a debug log message");
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");
        logger.info("This is my first log4j's statement");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}