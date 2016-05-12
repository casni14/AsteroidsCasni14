/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import org.openide.modules.ModuleInstall;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author casperbeese
 */
public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        
        ctx.register(EnemyConfig.class);
        ctx.refresh();
        
        EnemyPluginWrapper.enemyPlugin = (EnemyPluginBean) ctx.getBean(EnemyPluginBean.class);
        EnemyControlSystemWrapper.enemyControlSystem = (EnemyControlSystemBean) ctx.getBean(EnemyControlSystemBean.class);
    }
}
