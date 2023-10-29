package org.example.monster;

public class WereWolf extends Monster {
    public WereWolf() {
    }

    public WereWolf(String physicalForm) {
        super(physicalForm);
    }

    @Override
    public String monsterGreeting() {
        return super.monsterGreeting() + "I'm WereWolf ";

    }
}
