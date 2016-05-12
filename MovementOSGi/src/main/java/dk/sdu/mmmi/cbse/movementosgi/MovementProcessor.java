/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.movementosgi;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;

/**
 *
 * @author casperbeese
 */

public class MovementProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        
        float x = entity.getX();
        float y = entity.getY();
        float dt = gameData.getDelta();
        float dx = entity.getDx();
        float dy = entity.getDy();
        
        // set position
            x += dx * dt;
            if(x > gameData.getDisplayWidth()){
                x = 0;
            }else if(x < 0){
                x = gameData.getDisplayWidth();
            }
            
            y += dy * dt;
            if(y > gameData.getDisplayHeight()){
                y = 0;
            }else if(y < 0){
                y = gameData.getDisplayHeight();
            }
            
            entity.setPosition(x, y);
    }
    
}
