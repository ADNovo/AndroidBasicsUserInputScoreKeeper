package com.example.android.ginrummyscorekeeper;

public class Metric {
    private int value;
    private int id;

    Metric(int id){
        value = 0;
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void change(int points){
        value += points;
    }
}
