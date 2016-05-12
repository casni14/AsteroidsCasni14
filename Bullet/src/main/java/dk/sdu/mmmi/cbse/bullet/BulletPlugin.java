/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
@ServiceProvider(service = IGamePluginService.class)
public class BulletPlugin implements IGamePluginService {

    private final int MAX_BULLETS = 4;

    @Override
    public void start(GameData gameData, Map<String, Entity> world) {
        
        for (Entity player : world.values()) {
            if (player.getType() == EntityType.PLAYER) {
                BulletHandler.getInstance().setPlayer(player);
            }
        }
    }

    @Override
    public void stop(GameData gameData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
