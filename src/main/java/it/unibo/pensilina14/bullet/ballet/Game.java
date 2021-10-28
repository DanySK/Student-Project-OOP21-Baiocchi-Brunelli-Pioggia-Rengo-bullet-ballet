package it.unibo.pensilina14.bullet.ballet;

import it.unibo.pensilina14.bullet.ballet.core.GameEngine;
import it.unibo.pensilina14.bullet.ballet.graphics.scenes.AbstractScene;
import it.unibo.pensilina14.bullet.ballet.graphics.scenes.GameView;
import it.unibo.pensilina14.bullet.ballet.graphics.scenes.MapScene;
import it.unibo.pensilina14.bullet.ballet.logging.AppLogger;
import it.unibo.pensilina14.bullet.ballet.model.environment.GameState;

public class Game {
    private final GameState state;
    private final AbstractScene view;
    public final GameEngine engine;

    public enum Scenes {
    	/**
    	 * 
    	 */
        MENU_SCENE,
        /**
         * 
         */
        MAP_SCENE;
    }

    public Game() {
    	this.state = new GameState();
        this.view = new MapScene(this.state);
        this.engine = new GameEngine((GameView) this.view, this.state);
    }

    public Game(final GameState gameState, final GameView gameView, final GameEngine gameEngine) {
    	this.state = gameState;
    	this.view = (AbstractScene) gameView;
    	this.engine = gameEngine;
    }

    public final void start() {
    	AppLogger.getAppLogger().debug("Inside Game start() method.");
            this.engine.setup();
            AppLogger.getAppLogger().debug("Engine setup done.. Starting main loop.");
            this.engine.mainLoop();
    }

    public final AbstractScene getView() {
    	return this.view;
    }

}
