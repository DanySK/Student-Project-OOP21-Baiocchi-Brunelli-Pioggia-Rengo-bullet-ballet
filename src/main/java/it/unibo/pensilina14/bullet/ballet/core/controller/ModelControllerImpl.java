package it.unibo.pensilina14.bullet.ballet.core.controller;

import java.util.Optional;

import it.unibo.pensilina14.bullet.ballet.model.environment.GameState;

public class ModelControllerImpl implements ModelController{

	private final Optional<GameState> gameState;
	
	public ModelControllerImpl(final GameState gameState) {
		this.gameState = Optional.of(gameState);
	}

	@Override
	public Optional<GameState> getGameState() {
		return this.gameState;
	}
	
}
