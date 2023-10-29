package org.example.monster;

public class Monster {
    private String physicalForm;
    public Monster() {
    }

    public Monster(String physicalForm) {
        this.physicalForm = physicalForm;
    }

    public String getphysicalForm() {
        return physicalForm;
    }

    public void setphysicalForm(String physicalForm) {
        this.physicalForm = physicalForm;
    }

    public String monsterGreeting(){
        return "Hello, you are caught!";
    }

}
