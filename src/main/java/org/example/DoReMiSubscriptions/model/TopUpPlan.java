package org.example.DoReMiSubscriptions.model;

public class TopUpPlan {
    private String topUpName;
    private int maxDevices;
    private int amount;



    public TopUpPlan(String topUpName, int maxDevices, int amount) {
        this.topUpName = topUpName;
        this.maxDevices = maxDevices;
        this.amount = amount;
    }

    public String getTopUpName() {
        return topUpName;
    }

    public void setTopUpName(String topUpName) {
        this.topUpName = topUpName;
    }

    public int getMaxDevices() {
        return maxDevices;
    }

    public void setMaxDevices(int maxDevices) {
        this.maxDevices = maxDevices;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
