/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import static dk.sdu.mmmi.cbse.common.data.EntityType.PLAYER;
import static dk.sdu.mmmi.cbse.common.data.EntityType.ENEMY;
import static dk.sdu.mmmi.cbse.common.events.EventType.ENEMY_SHOOT;
import static dk.sdu.mmmi.cbse.common.events.EventType.PLAYER_SHOOT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.SPACE;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.events.EventType;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class BulletProcessor implements IEntityProcessingService {

    private final int MAX_BULLETS = 4;

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
//        if (BulletHandler.getInstance().getBulletCounter() == MAX_BULLETS) {
//            return;
//        }

        for (Entity ent : world.values()) {
            if (ent.getType().equals(PLAYER)) {
                 for (Event evt : gameData.getEvents()) {
                    if (evt.getType().equals(PLAYER_SHOOT)) {
                        BulletHandler.getInstance().insertBullet(entity);
                        
                    }
                }
            }
            if (ent.getType().equals(ENEMY)) {
                for (Event evt : gameData.getEvents()) {
                    if (evt.getType().equals(ENEMY_SHOOT)) {
                        BulletHandler.getInstance().insertBullet(entity);
                    }
                }
            }
        }

        updateBullet(entity, gameData.getDelta());
    }

    private void updateBullet(Entity entity, float dt) {
        float x = entity.getX();
        float y = entity.getY();
        float dx = entity.getDx();
        float dy = entity.getDy();

        x += dx * dt;
        y += dy * dt;

        entity.setX(x);
        entity.setY(y);

    }

}
