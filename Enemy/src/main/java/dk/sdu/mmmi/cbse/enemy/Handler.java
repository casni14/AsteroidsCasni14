/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author casperbeese
 */
public class Handler {
    
    private Handler() {
    }
    
    public static Handler getInstance() {
        return HandlerHolder.INSTANCE;
    }
    
    private static class HandlerHolder {

        private static final Handler INSTANCE = new Handler();
    }
    
    protected void installBeans() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        
        ctx.register(EnemyConfig.class);
        ctx.refresh();
        
        EnemyPluginWrapper.enemyPlugin = (EnemyPluginBean) ctx.getBean(EnemyPluginBean.class);
        EnemyProcessingServiceWrapper.enemyProcessingService = (EnemyProcessingSerivceBean) ctx.getBean(EnemyProcessingSerivceBean.class);
    }
}
