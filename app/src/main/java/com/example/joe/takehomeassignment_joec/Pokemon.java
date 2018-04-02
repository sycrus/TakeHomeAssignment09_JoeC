package com.example.joe.takehomeassignment_joec;

public class Pokemon {
    private String name;
    private int number;
    private boolean isCaught = false;

    public Pokemon(String name, int number, boolean isCaught) {
        this.name = name;
        this.number = number;
        this.isCaught = isCaught;
    }

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught(boolean caught) {
        isCaught = caught;
    }


}
