package it.unibo.pensilina14.bullet.ballet.model.weapon;
import it.unibo.pensilina14.bullet.ballet.model.effects.Effect;


public class BulletImpl implements Bullet {

	private final String name;
	private final double damage;
	
	public BulletImpl(BulletType bulletType) {
		this.name = bulletType.toString();
		this.damage = bulletType.getDamage();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getDamage() {
		return damage;
	}

	@Override
	public Effect getEffect() {
		return null;
	}

    @Override
    public ITEM_ID getItemId() {
        // TODO Auto-generated method stub
        return null;
    }

}