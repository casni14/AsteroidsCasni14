/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import java.util.Map;

/**
 *
 * @author casperbeese
 */
public class BulletHandler {

    private int bulletCounter;
    private Entity player;
    private Map<String, Entity> world;

    private BulletHandler() {
    }

    public static BulletHandler getInstance() {
        return BulletHandlerHolder.INSTANCE;
    }

    private static class BulletHandlerHolder {

        private static final BulletHandler INSTANCE = new BulletHandler();
    }

    protected void insertBullet(Entity entity) {
        Entity player = new Entity();
        player = getPlayer();
        float x = player.getX();
        float y = player.getY();
        float radians = player.getRadians();

        Entity bullet = new Entity();

        bullet.setX(x);
        bullet.setY(y);
        bullet.setRadians(radians);
        bullet.setMaxSpeed(350);
        bullet.setDx((float) Math.cos(radians) * player.getMaxSpeed());
        bullet.setDy((float) Math.sin(radians) * player.getMaxSpeed());
        bullet.setRadius(2);

        world.put(bullet.getID(), bullet);
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

    public Map<String, Entity> getWorld() {
        return world;
    }

    public void setWorld(Map<String, Entity> world) {
        this.world = world;
    }

}
