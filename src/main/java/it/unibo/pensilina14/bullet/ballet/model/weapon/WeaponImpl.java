package it.unibo.pensilina14.bullet.ballet.model.weapon;

import java.util.ArrayList;
import java.util.Arrays;

import it.unibo.pensilina14.bullet.ballet.model.effects.Effect;

public class WeaponImpl implements Weapon {

	//set for each weapon the total number of available bullets
	private final static int MAX_AMMO = 10;
	private final String name;
	private int currentAmmo;
	private ArrayList<Bullet> spareCharger = new ArrayList<>();
	
	public WeaponImpl(String nameOfWeapon) {
		this.name = nameOfWeapon;
		this.currentAmmo = MAX_AMMO;
		spareCharger.ensureCapacity(MAX_AMMO);
		spareCharger.stream().map(i -> new BulletImpl(BulletType.CLASSICAL));
		//for(int i=0; i<MAX_AMMO; i++) {
		//	spareCharger.add(new BulletImpl(BulletType.CLASSICAL));
		//}
	}
	
	@Override
	public int getAmmoLeft() {
		return currentAmmo;
	}
	
	@Override
	public int getTotalAmmo() {
		return MAX_AMMO;
	}
	
	@Override
	public void decreaseAmmo() {
		if(hasAmmo() == true) {
			currentAmmo--;
			spareCharger.remove(currentAmmo--);
		}
	}
	
	@Override
	public boolean shoot() {
		return false;
	}
	
	@Override
	public boolean hasAmmo() {
		return 	spareCharger.isEmpty();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Effect getEffect() {
		return null;
	}
	
	@Override
	public boolean recharge(Bullet singleBullet, Bullet[] charger) {
		for(Bullet bullet: charger) {
			spareCharger.add(bullet);
		}
		return false;
	}

    @Override
    public ITEM_ID getItemId() {
        // TODO Auto-generated method stub
        return null;
    }

}