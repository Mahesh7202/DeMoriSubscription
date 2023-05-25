package com.example.geektrust.modal;

public class TopUpPlan {
    private String topUpName;
    private int maxDevices;
    private int amount;

    public TopUpPlan(String topUpName, int maxDevices, int amount) {
        this.topUpName = topUpName;
        this.maxDevices = maxDevices;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}

