/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author casperbeese
 */
public class AsteroidHandler {

    private Entity player;
    private Map<String, Entity> world;
    private GameData gameData;
    private Random rd = new Random();
    private final float LARGE = 40;
    private final float MEDIUM = 20;
    private final float SMALL = 12;

    private AsteroidHandler() {

    }

    public static AsteroidHandler getInstance() {
        return AsteroidHandlerHolder.INSTANCE;
    }

    private static class AsteroidHandlerHolder {

        private static final AsteroidHandler INSTANCE = new AsteroidHandler();
    }

    protected void insertAsteroid() {

        Entity flyingAsteroid = new Entity();
        int numPoints = 12;

        flyingAsteroid.setType(EntityType.ASTEROIDS);

        flyingAsteroid.setX(rd.nextFloat() * gameData.getDisplayWidth());
        flyingAsteroid.setY(rd.nextFloat() * gameData.getDisplayHeight());

        flyingAsteroid.setDx(flyingAsteroid.getX() /*- player.getX()*/);
        flyingAsteroid.setDy(flyingAsteroid.getY() /*- player.getY()*/);

        flyingAsteroid.setShapeX(new float[numPoints]);
        flyingAsteroid.setShapeY(new float[numPoints]);
        flyingAsteroid.setDists(new float[numPoints]);

        flyingAsteroid.setMaxSpeed(rd.nextFloat() * 10 + 21);

        flyingAsteroid.setRadians(rd.nextFloat() * (2 * 3.1415f));

        flyingAsteroid.setIsHit(false);

        float radius = LARGE;
        flyingAsteroid.setRadius(radius);
        for (int i = 0; i < flyingAsteroid.getShapeX().length; i++) {
            flyingAsteroid.getDists()[i] = rd.nextFloat() * (radius - radius / 2) + radius / 2;
        }

        world.put(flyingAsteroid.getID(), flyingAsteroid);
    }

    protected void insertAsteroid(Entity entity) {
        Entity flyingAsteroid = new Entity();
        int numPoints = 12;

        flyingAsteroid.setType(EntityType.ASTEROIDS);

        flyingAsteroid.setX(entity.getX());
        flyingAsteroid.setY(entity.getY());

        flyingAsteroid.setDx(flyingAsteroid.getX() /*- player.getX()*/);
        flyingAsteroid.setDy(flyingAsteroid.getY() /*- player.getY()*/);

        flyingAsteroid.setShapeX(new float[numPoints]);
        flyingAsteroid.setShapeY(new float[numPoints]);
        flyingAsteroid.setDists(new float[numPoints]);

        flyingAsteroid.setMaxSpeed(rd.nextFloat() * 10 + 21);

        flyingAsteroid.setRadians(rd.nextFloat() * (2 * 3.1415f));

        flyingAsteroid.setIsHit(false);

        float radius = flyingAsteroid.getRadius();
        
        if (entity.getRadius() == LARGE) {
            radius = MEDIUM;
        }
        if (entity.getRadius() == MEDIUM) {
            radius = SMALL;
        }
        flyingAsteroid.setRadius(radius);
        for (int i = 0; i < flyingAsteroid.getShapeX().length; i++) {
            flyingAsteroid.getDists()[i] = rd.nextFloat() * (radius - radius / 2) + radius / 2;
        }

        world.put(flyingAsteroid.getID(), flyingAsteroid);
    }


    protected void checkCollitions(Entity entity) {
        if (!player.getIsHit()) {
            if (intersects(entity)) {
                //player.setIsHit(true);
                world.remove(entity.getID());
                splitAsteroids(entity);
            }
        }
    }

    private boolean intersects(Entity entity) {
        float[] sx = player.getShapeX();
        float[] sy = player.getShapeY();
        for (int i = 0; i < sx.length; i++) {
            if (contains(sx[i], sy[i], entity)) {
                return true;
            }
        }
        return false;
    }

    private boolean contains(float x, float y, Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();

        boolean b = false;
        for (int i = 0, j = shapex.length - 1;
                i < shapex.length;
                j = i++) {
            if ((shapey[i] > y) != (shapey[j] > y)
                    && (x < (shapex[j] - shapex[i])
                    * (y - shapey[i]) / (shapey[j] - shapey[i])
                    + shapex[i])) {
                b = !b;
            }
        }
        return b;
    }

    private void splitAsteroids(Entity entity) {
        if (entity.getRadius() == LARGE) {
            insertAsteroid(entity);
            insertAsteroid(entity);
        }
        if (entity.getRadius() == MEDIUM) {
            insertAsteroid(entity);
            insertAsteroid(entity);
        }
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

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

}
