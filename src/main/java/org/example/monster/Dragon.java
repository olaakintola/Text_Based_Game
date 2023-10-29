package org.example.monster;

public class Dragon extends Monster {
    public Dragon() {
    }

    public Dragon(String physicalForm) {
        super(physicalForm);
    }

    @Override
    public String monsterGreeting() {
        return super.monsterGreeting() + ", I'm Dragon ";

    }
}
