/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
public class EnemyPluginBean {
    
    Map<String, Entity> world;
    Entity enemy;

    
    public void start(GameData gameData, Map<String, Entity> world) {
        System.out.println("Started EnemyPlugin");
        
        this.world = world;
        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.put(enemy.getID(), enemy);
    }
    
    private Entity createEnemyShip(GameData gamedata){
        Entity enemyShip = new Entity();
        Random rd = new Random();
      
        
        enemyShip.setType(EntityType.ENEMY);
        
        enemyShip.setMaxSpeed(70);
        
        enemyShip.setX(gamedata.getDisplayWidth() - 50);
        enemyShip.setY(rd.nextFloat() * gamedata.getDisplayHeight());
        enemyShip.setDx(-enemyShip.getMaxSpeed());
        

        enemyShip.setShapeX(new float[6]);
        enemyShip.setShapeY(new float[6]);
        
        enemyShip.setLife(1);
        
        enemyShip.setRadius(4);
        
        return enemyShip;
    }

    
    public void stop(GameData gameData) {
       world.remove(enemy);
    }
    
}
