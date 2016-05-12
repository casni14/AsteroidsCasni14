/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import static dk.sdu.mmmi.cbse.common.data.EntityType.PLAYER;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
public class EnemyControlSystemBean {

    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {

        float pathTimer = 0;
        float pathTime1 = 2;
        float pathTime2 = pathTime1 + 2;
        float x = entity.getX();
        float y = entity.getY();
        float dt = gameData.getDelta();
        float dx = entity.getDx();
        float dy = entity.getDy();
        float speed = entity.getMaxSpeed();
        Entity player = new Entity();
        System.out.println("stil processing");
        for (Entity ent : world.values()) {
            if (ent.getType() == PLAYER) {
                player = ent;
            }
        }
        if (entity.getType().equals(ENEMY)) {
            
            if (!player.getIsHit()) {
                
            }
            //move along path
            pathTimer = dt;

            // move forward
            if (pathTimer < pathTime1) {
                dy = 0;
            }

            // move downward
            if (pathTimer > pathTime1 && pathTimer < pathTime2) {
                dy = -speed;
            }

            // move to end of screen
            if (pathTimer > pathTime1 + pathTime2) {
               dy = 0;
            }

            x += dx * dt;
            y += dy * dt;
            
            entity.setX(x);
            entity.setY(y);
            entity.setDx(dx);
            entity.setDy(dy);

            updateShape(entity);
        }

    }

    private void updateShape(Entity entity) {

        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        float x = entity.getX();
        float y = entity.getY();

        shapex[0] = x - 10;
        shapey[0] = y;

        shapex[1] = x - 3;
        shapey[1] = y - 5;

        shapex[2] = x + 3;
        shapey[2] = y - 5;

        shapex[3] = x + 10;
        shapey[3] = y;

        shapex[4] = x + 3;
        shapey[4] = y + 5;

        shapex[5] = x - 3;
        shapey[5] = y + 5;

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
