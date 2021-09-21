package it.unibo.pensilina14.bullet.ballet.menu.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuTest extends Application{

    @Override
    public void start(final Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource("fxml.menu.homepage.fxml"));
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(final String[] args) {
        launch(args);
    }
    
}
