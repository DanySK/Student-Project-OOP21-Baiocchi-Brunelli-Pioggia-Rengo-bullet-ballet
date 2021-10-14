package it.unibo.pensilina14.bullet.ballet.graphics.sprite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import it.unibo.pensilina14.bullet.ballet.common.Dimension2Dimpl;
import it.unibo.pensilina14.bullet.ballet.common.MutablePosition2Dimpl;
import it.unibo.pensilina14.bullet.ballet.common.SpeedVector2DImpl;
import it.unibo.pensilina14.bullet.ballet.model.characters.EntityList;
import it.unibo.pensilina14.bullet.ballet.model.environment.GameEnvironment;
import it.unibo.pensilina14.bullet.ballet.model.weapon.ITEM_ID;
import it.unibo.pensilina14.bullet.ballet.model.weapon.Weapon;
import it.unibo.pensilina14.bullet.ballet.model.weapon.WeaponImpl;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class WeaponSprite extends Pane {
	
	private enum WeaponsImg {
		
		GUN("res/assets/sprites/weapons/...png"),
		SHOTGUN("res/assets/sprites/weapons/...png"),
		AUTO("res/assets/sprites/weapons/...png\"");
		
		String path;
		
		WeaponsImg(final String path){
			this.path = path;
		}
		
		public String getPath() {
			return this.path;
		}
	}
	/// Add image for weapon
	final Image weaponImg;
	
	final ImageView weaponView;
	boolean attached = false;
    int columns = 2;
    int minY;
    int minX;
    int weaponWidth;
    int weaponHeight;
    Weapon weapon;
    
    public WeaponSprite(final WeaponsImg img, final double x, final double y, final Weapon weapon) throws  IOException{
    	
    	this.weapon = weapon;
    	this.weaponImg = new Image(Files.newInputStream(Paths.get(img.getPath())));
    	this.weaponView = new ImageView(this.weaponImg);
    	this.minX = 0;
    	this.minY = 0;
    	this.weaponHeight = 25;
    	this.weaponWidth = 50;
    	this.setTranslateX(x);
    	this.setTranslateY(y);
    	this.weaponView.setViewport(new Rectangle2D(this.minX, this.minY, this.weaponWidth, this.weaponHeight));
    	
    	getChildren().addAll(this);
    }
    
    
    
 /*    
    public Point2D weaponVelocity = new Point2D(0,0);
    
    public static final int WEAPON_SIZE = 20;
    public static final int MASS = 10;
    
    final Weapon weapon;
    
    public WeaponSprite() {
    	this.weapon = new WeaponImpl(EntityList.Weapons.GUN,  new Dimension2Dimpl(WEAPON_SIZE, WEAPON_SIZE),
    			new GameEnvironment(), MASS, new SpeedVector2DImpl(new MutablePosition2Dimpl(this.offsetX, this.offsetY), 0),
				ITEM_ID.WEAPON, null);
    	this.weaponView.setFitHeight(WeaponSprite.WEAPON_SIZE);
    	this.weaponView.setFitWidth(WeaponSprite.WEAPON_SIZE);
    	this.weaponView.setViewport(new Rectangle2D(this.offsetX, this.offsetY, this.weaponViewWidth, this.weaponViewHeight));
    	
    	getChildren().addAll(this.weaponView);
    }
   */
}