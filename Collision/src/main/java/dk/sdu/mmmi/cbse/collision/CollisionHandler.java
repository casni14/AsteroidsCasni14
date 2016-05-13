/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

/**
 *
 * @author casperbeese
 */
public class CollisionHandler {
    
    private CollisionHandler() {
    }
    
    public static CollisionHandler getInstance() {
        return CollisionHandlerHolder.INSTANCE;
    }
    
    private static class CollisionHandlerHolder {

        private static final CollisionHandler INSTANCE = new CollisionHandler();
    }
    
    
}
