package org.example;

import org.example.monster.Dragon;
import org.example.monster.Monster;
import org.example.monster.WereWolf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {
    private Monster monster;

    @Test
    public void testDragonGreeting(){
        monster = new Dragon("Dragon");
        assertEquals("Hello, you are caught!, I'm Dragon : Dragon", monster.monsterGreeting());
    }

    @Test
    public void testWereWolfGreeting(){
        monster = new WereWolf("WereWolf");
        assertEquals("Hello, you are caught!I'm WereWolf: WereWolf", monster.monsterGreeting());
    }
}
