/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ASTEROIDS;
import java.util.Map;
import java.util.Random;
//import static java.lang.Math.cos;
//import static java.lang.Math.sin;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class AsteroidProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        float x = entity.getX();
        float y = entity.getY();
        float dt = gameData.getDelta();
        float dx;
        float dy;
        float maxSpeed = entity.getMaxSpeed();
        float radians = entity.getRadians();
        float rotationSpeed = entity.getRotationSpeed();


        if (entity.getType().equals(ASTEROIDS)) {


            dx = (float) Math.cos(radians) * maxSpeed;
            dy = (float) Math.sin(radians) * maxSpeed;

            x += dx * dt;
            y += dy * dt;

            radians += rotationSpeed * dt;

            entity.setDx(dx);
            entity.setDy(dy);
            entity.setRadians(radians);
            AsteroidHandler.getInstance().checkCollitions(entity);
            AsteroidHandler.getInstance().updateShape(entity);
            
        }

    }

//    private void updateShape(Entity entity) {
//
//        float angle = 0;
//        float[] shapex = entity.getShapeX();
//        float[] shapey = entity.getShapeY();
//        float[] dists = entity.getDists();
//        float x = entity.getX();
//        float y = entity.getY();
//        float radians = entity.getRadians();
//
//        for (int i = 0; i < shapex.length; i++) {
//            shapex[i] = x + (float) Math.cos(angle + radians) * dists[i];
//            shapey[i] = y + (float) Math.sin(angle + radians) * dists[i];
//
//            angle += 2 * 3.1415f / shapex.length;
//        }
//
//        entity.setShapeX(shapex);
//        entity.setShapeY(shapey);
//
//    }
//
//    private void checkCollitions(Entity entity) {
//        if (!player.getIsHit()) {
//            if (intersects(entity)) {
//                player.setIsHit(true);
//                world.remove(entity.getID());
//                splitAsteroids(entity);
//            }
//        }
//    }
//
//    private boolean intersects(Entity entity) {
//        float[] sx = player.getShapeX();
//        float[] sy = player.getShapeY();
//        for (int i = 0; i < sx.length; i++) {
//            if (contains(sx[i], sy[i], entity)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean contains(float x, float y, Entity entity) {
//        float[] shapex = entity.getShapeX();
//        float[] shapey = entity.getShapeY();
//
//        boolean b = false;
//        for (int i = 0, j = shapex.length - 1;
//                i < shapex.length;
//                j = i++) {
//            if ((shapey[i] > y) != (shapey[j] > y)
//                    && (x < (shapex[j] - shapex[i])
//                    * (y - shapey[i]) / (shapey[j] - shapey[i])
//                    + shapex[i])) {
//                b = !b;
//            }
//        }
//        return b;
//    }
//
//    private void splitAsteroids(Entity entity) {
//        if (entity.getRadius() == 40) {
//            asteroid.setRadius(20);
//            asteroid2.setRadius(20);
//            asteroid = ap.createAsteroid(gd);
//            asteroid2 = ap.createAsteroid(gd);
//            
//            world.put(asteroid.getID(), asteroid);
//            world.put(asteroid2.getID(), asteroid2);
//        }
//        if (entity.getRadius() == 20) {
//             asteroid.setRadius(12);
//            asteroid2.setRadius(12);
//            asteroid = ap.createAsteroid(gd);
//            asteroid2 = ap.createAsteroid(gd);
//           
//            world.put(asteroid.getID(), asteroid);
//            world.put(asteroid2.getID(), asteroid2);
//        }
//    }
}
