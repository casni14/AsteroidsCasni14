/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author casperbeese
 */
public class EntityPluginTest {
    
    public EntityPluginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class EntityPlugin.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        GameData gameData = null;
        Map<String, Entity> world = null;
        EntityPlugin instance = new EntityPlugin();
        instance.start(gameData, world);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class EntityPlugin.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        GameData gameData = null;
        EntityPlugin instance = new EntityPlugin();
        instance.stop(gameData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
