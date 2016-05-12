/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import static dk.sdu.mmmi.cbse.common.data.EntityType.PLAYER;
import java.util.Map;
import java.util.Random;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
@ServiceProvider(service = IGamePluginService.class)
public class AsteroidPlugin implements IGamePluginService {

    Random rd = new Random();

    @Override
    public void start(GameData gameData, Map<String, Entity> world) {

        AsteroidHandler.getInstance().setWorld(world);
        AsteroidHandler.getInstance().setGameData(gameData);

        for (Entity ent : world.values()) {
            if (ent.getType() == PLAYER) {
                AsteroidHandler.getInstance().setPlayer(ent);
            }
        }
        
        // Add entities to the world
        for (int i = 0; i < 4; i++){
            AsteroidHandler.getInstance().insertAsteroid();
        }
    
        
       // world.put(asteroid.getID(), asteroid);

    }

    @Override
    public void stop(GameData gameData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
