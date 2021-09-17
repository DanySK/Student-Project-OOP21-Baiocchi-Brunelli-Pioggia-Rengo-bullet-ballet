package it.unibo.pensilina14.bullet.ballet.environment.PhysicalObject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unibo.pensilina14.bullet.ballet.environment.Environment;
import it.unibo.pensilina14.bullet.ballet.environment.GameEnvironment;
import it.unibo.pensilina14.bullet.ballet.misc.utilities2D.Dimension2D;
import it.unibo.pensilina14.bullet.ballet.misc.utilities2D.Dimension2Dimpl;
import it.unibo.pensilina14.bullet.ballet.misc.utilities2D.MutablePosition2D;
import it.unibo.pensilina14.bullet.ballet.misc.utilities2D.MutablePosition2Dimpl;
import it.unibo.pensilina14.bullet.ballet.weapon.DynamicPickupItem;
import it.unibo.pensilina14.bullet.ballet.weapon.ITEM_ID;

public class ItemTest {
    
    private static final int DIMENSION = 1;
    private static final int POSITION = -5;
    private static final int MASS = 100;
    
    private DynamicPickupItem dynItem = new DynamicPickupItem(new Dimension2Dimpl(DIMENSION, DIMENSION)
            , new MutablePosition2Dimpl(POSITION, POSITION), new GameEnvironment(), MASS, null, ITEM_ID.HEART);
    
    @Test
    public void yAxisMovementTest() {
        final Environment gameEnv = new GameEnvironment();
        final Dimension2D gameEnvDim = gameEnv.getDimension();
        final Dimension2D itemDim = dynItem.getDimension();
        final MutablePosition2D itemPos = dynItem.getPosition();
        dynItem.yAxisMovement();
        final MutablePosition2D actualPosition = dynItem.getPosition();
        MutablePosition2D expectedPosition = new MutablePosition2Dimpl(itemPos.getX()
                , -gameEnvDim.getHeight() + itemDim.getHeight()); 
        assertEquals(actualPosition.getCoordinates(), expectedPosition.getCoordinates());
    }
    
    
    @Test 
    public void xAxisMovementTest() {
        final Environment gameEnv = new GameEnvironment();
        final Dimension2D gameEnvDim = gameEnv.getDimension();
        final MutablePosition2D itemPos = dynItem.getPosition();
        dynItem.xAxisMovement();
        final MutablePosition2D actualPosition = dynItem.getPosition();
        MutablePosition2D expectedPosition = new MutablePosition2Dimpl(-gameEnvDim.getWidth()
                , itemPos.getY()); 
        assertEquals(actualPosition.getCoordinates(), expectedPosition.getCoordinates());
    }
    
}
