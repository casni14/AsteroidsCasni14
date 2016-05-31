/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
public class AsteroidProcessorTest {

    GameData gameData = new GameData();
    Map<String, Entity> world = new ConcurrentHashMap<>();
    Entity entity = new Entity();
    GameKeys gameKeys = new GameKeys();

    public AsteroidProcessorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        world.put(entity.getID(), entity);
        gameData.setDelta(5);
        entity.setX(50);
        entity.setY(50);
        entity.setMaxSpeed(50);
        entity.setRadians(2);
        entity.setRotationSpeed(12);
        entity.setType(EntityType.ASTEROIDS);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRotation() {
        System.out.println("Rotation test");
        AsteroidProcessor instance = new AsteroidProcessor();

        float radians1 = entity.getRadians();
        instance.process(gameData, world, entity);
        float radians2 = entity.getRadians();
        assertFalse(radians1 == radians2);

    }

}
