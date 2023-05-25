package com.example.geektrust.constants;

public enum Device {

    FOUR_DEVICE("FOUR_DEVICE", 4, 50),
    TEN_DEVICE("TEN_DEVICE", 10, 100);

    private final String name;
    private final int count;
    private final int cost;

    Device(String name, int count, int cost) {
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return cost;
    }
}


