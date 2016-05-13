/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Map;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author casperbeese
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class EnemyProcessingServiceWrapper implements IEntityProcessingService {

    protected static EnemyProcessingSerivceBean enemyProcessingService;

    @Override
    public void process(GameData gameData, Map<String, Entity> world, Entity entity) {
        if (enemyProcessingService != null) {
            enemyProcessingService.process(gameData, world, entity);
        }
        
    }

}
