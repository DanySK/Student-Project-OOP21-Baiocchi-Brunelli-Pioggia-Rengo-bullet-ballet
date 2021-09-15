package it.unibo.pensilina14.bullet.ballet.weapon;

import java.util.stream.IntStream;

import it.unibo.pensilina14.bullet.ballet.environment.Environment;
import it.unibo.pensilina14.bullet.ballet.game.effects.Effect;
import it.unibo.pensilina14.bullet.ballet.game.entities.AbstractDynamicComponent;
import it.unibo.pensilina14.bullet.ballet.misc.utilities2D.Dimension2D;
import it.unibo.pensilina14.bullet.ballet.misc.utilities2D.MutablePosition2D;

public class DynamicPickupItem extends AbstractDynamicComponent implements Item{

    private final ITEM_ID id;
    private final Effect effect;
    
    public DynamicPickupItem(Dimension2D dimension, MutablePosition2D position
            , Environment gameEnvironment, double mass,
            Effect effect, ITEM_ID id) {
        super(dimension, position, gameEnvironment, mass);
        this.effect = effect;
        this.id = id;
    }

    @Override
    public Effect getEffect() {
        return this.effect;
    }

    @Override
    public ITEM_ID getItemId() {
        return this.id;
    }
    
    /*
     *TODO = refactor with java streams 
    */
    public void yAxisMovement() {
        while (this.moveUP(1)) {};
        while (this.moveDOWN(1)) {};
    }
    
}
