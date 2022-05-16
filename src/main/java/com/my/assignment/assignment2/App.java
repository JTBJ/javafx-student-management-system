package com.my.assignment.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("TMSFX - Faculty Mode");
        stage.setScene(scene);
        App.stage.show();
    }

    public static void setRoot(String fxml, String title) throws IOException {
        stage.setTitle(title);
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void changeRoot(String fxml, String title, int stageWidth, int stageHeight) throws IOException {
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        App.setRoot(fxml, title);
    }

    public static void main(String[] args) {
        launch();
    }
}