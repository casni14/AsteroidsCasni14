/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author casperbeese
 */
@Configuration
public class EnemyConfig {
    
    @Bean
    @Scope(value = "prototype")
    public EnemyProcessingSerivceBean createEnemyProcessingService(){
        return new EnemyProcessingSerivceBean();
    }
    
    @Bean
    @Scope(value = "prototype")
    public EnemyPluginBean createEnemyPluginService(){
        return new EnemyPluginBean();
    }
}
