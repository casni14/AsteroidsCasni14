/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author casperbeese
 */
public class BulletHandler {

    private int bulletCounter;
    private Entity player;

    private BulletHandler() {
    }

    public static BulletHandler getInstance() {
        return BulletHandlerHolder.INSTANCE;
    }

    private static class BulletHandlerHolder {

        private static final BulletHandler INSTANCE = new BulletHandler();
    }

    protected void insertBullet(Entity entity) {
        float x = getPlayer().getX();
        float y = getPlayer().getY();
        float radians = getPlayer().getRadians();

        Entity bullet = new Entity();
        
        bullet.setX(x);
        bullet.setY(y);
        bullet.setRadians(radians);
        bullet.setMaxSpeed(350);
        bullet.setDx((float) Math.cos(radians) * getPlayer().getMaxSpeed());
        bullet.setRadius(2);
        
    }

    public int getBulletCounter() {
        return bulletCounter;
    }

    public void setBulletCounter(int bulletCounter) {
        this.bulletCounter = bulletCounter;
    }

    public Entity getPlayer() {
        return player;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

}
