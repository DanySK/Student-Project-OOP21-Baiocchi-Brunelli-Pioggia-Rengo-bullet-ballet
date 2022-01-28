package it.unibo.pensilina14.bullet.ballet.menu.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import it.unibo.pensilina14.bullet.ballet.save.Save;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PageLoaderImpl implements PageLoader{
    
    private static final String LANGUAGES_PATH = "languages.bulletBallet";

    //TODO: volendo si possono unire in un metodo quelli con la lingua e quelli con la width e la height.

    @Override
	public void goToSelectedPageOnInput(final Frames frame, final MouseEvent event, final Languages language) throws IOException {
    	final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(frame.toString())), getLanguage(language));
        final Scene scene = new Scene(root);
        final Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
        window.show();
	}

    @Override
    public void goToSelectedPageOnInput(final Frames frame, final MouseEvent event, final Languages language, final int width, final int height) throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(frame.toString())), getLanguage(language));
        final Scene scene = new Scene(root, width, height);
        final Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
        window.show();
    }

    @Override
    public void goToSelectedPageOnInput(final Frames frame, final MouseEvent event) throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(frame.toString())), getLanguage(Languages.ENGLISH));
        final Scene scene = new Scene(root, getScreenWidth(), getScreenHeight());
        final Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void goToSelectedPageOnInput(final Frames frame) throws IOException { 
    	final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(frame.toString())), getLanguage(Languages.ENGLISH));
    	final Scene scene = new Scene(root, getScreenWidth(), getScreenHeight());
    	final Stage window = new Stage();
    	window.setScene(scene);
    	window.show();
    }
    
    @Override
	public void loadFirstScene(final Stage primaryStage, final Languages language) throws IOException {
    	final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Frames.HOMEPAGE.toString())), getLanguage(language));
        final Scene scene = new Scene(root);
        primaryStage.setTitle("bullet-ballet");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

    @Override
    public void loadFirstScene(final Stage primaryStage, final Languages language, final int width, final int height) throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Frames.HOMEPAGE.toString())), getLanguage(language));
        final Scene scene = new Scene(root, width, height);
        primaryStage.setTitle("bullet-ballet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void loadFirstScene (final Stage primaryStage) throws IOException{
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Frames.HOMEPAGE.toString())), getLanguage(Languages.ENGLISH));
        final Scene scene = new Scene(root, getScreenWidth(), getScreenHeight());
        primaryStage.setTitle("bullet-ballet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   private ResourceBundle getLanguage(final Languages language) {
	    final Locale locale = new Locale(composeLanguageString(language));
	    return ResourceBundle.getBundle(PageLoaderImpl.LANGUAGES_PATH, locale);
    }
    
    private String composeLanguageString(final Languages language) {
    	return !Save.loadSettings().isEmpty() ? Save.loadSettings().get(Save.LANGUAGE_STRING) : language.getCountryCode();
    }

    private int getScreenWidth() {
        return !Save.loadSettings().isEmpty() ? Integer.parseInt(Save.loadSettings().get(Save.RESOLUTION_WIDTH_STRING)) : Resolutions.getDefaultResolution().getWidth();
    }

    private int getScreenHeight() {
        return !Save.loadSettings().isEmpty() ? Integer.parseInt(Save.loadSettings().get(Save.RESOLUTION_HEIGHT_STRING)) : Resolutions.getDefaultResolution().getHeight();
    }
    
}
