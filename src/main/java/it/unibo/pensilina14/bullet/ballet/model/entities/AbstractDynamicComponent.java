package it.unibo.pensilina14.bullet.ballet.model.entities;

import it.unibo.pensilina14.bullet.ballet.common.Dimension2D;
import it.unibo.pensilina14.bullet.ballet.common.MutablePosition2D;
import it.unibo.pensilina14.bullet.ballet.common.SpeedVector2D;
import it.unibo.pensilina14.bullet.ballet.model.environment.Environment;

public abstract class AbstractDynamicComponent implements PhysicalObject{
    
    private static final double MS_TO_S = 0.001;
    private final Dimension2D dimension;
    private final Environment gameEnvironment;
    private final double mass;
    private final SpeedVector2D vector;
    
    public AbstractDynamicComponent(final Dimension2D dimension, 
            final Environment gameEnvironment, final double mass, 
            final SpeedVector2D vector) {
        this.dimension = dimension;
        this.gameEnvironment = gameEnvironment;
        this.mass = mass;
        this.vector = vector;
    }

    @Override
    public MutablePosition2D getPosition() {
        return this.vector.getPosition();
    }

    @Override
    public Boolean isCollidingWith(final PhysicalObject other) {
        return null;
    }

    @Override
    public Dimension2D getDimension() {
        return this.dimension;
    }

    @Override
    public Environment getGameEnvironment() {
        return this.gameEnvironment;
    }

    public SpeedVector2D getSpeedVector() {
        return this.vector;
    }
    
    public double getMass() {
        return this.mass;
    }
    
    public boolean moveUP(final double y) {
        return this.move(0, Math.abs(y));
    }
    
    public boolean moveDOWN(final double y) {
        return this.move(0, -Math.abs(y));
    }
    
    public boolean moveRIGHT(final double x) {
        return this.move(Math.abs(x), 0);
    }
    
    public boolean moveLEFT(final double x) {
        return this.move(-Math.abs(x), 0);
    }
    
    public boolean move(final double x, final double y) {
        if (isWithinMapBoundaries(x * this.vector.getSpeed(), y * this.vector.getSpeed())) {
            this.vector.vectorSum(x, y);
            return true;
        }
        return false;
    }
    
    public void updateState(final double dt) {
        this.vector.noSpeedVectorSum(dt * MS_TO_S, dt * MS_TO_S);
    }
    
    private boolean isWithinMapBoundaries(final double x, final double y) {    
        return isWithinXaxis(x) && isWithinYaxis(y);
    }
    
    private boolean isWithinXaxis(final double x) {
        final Dimension2D envDimension = this.gameEnvironment.getDimension();
        return this.vector.getPosition().getX() + x >= -envDimension.getWidth()
                && this.vector.getPosition().getX() + x + this.dimension.getWidth() <= 0;
    }
    
    private boolean isWithinYaxis(final double y) {
        final Dimension2D envDimension = this.gameEnvironment.getDimension();
        return this.vector.getPosition().getY() + y <= 0
                && this.vector.getPosition().getY() + y - this.dimension.getHeight() >= -envDimension.getHeight();
    }
    
    public double getGravityForce() {
        return gameEnvironment.getGravity() * this.mass;
    }

}