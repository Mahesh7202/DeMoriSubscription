package com.example.geektrust.modal;

public class TopUp {
    private TopUpPlan topUpPlan;
    private int devices;

    private int billAmount;

    public TopUp(TopUpPlan topUpPlan, int devices) {
        this.topUpPlan = topUpPlan;
        this.devices = devices;
    }

    public TopUpPlan getTopUpPlan() {
        return topUpPlan;
    }

    public int getDevices() {
        return devices;
    }


    public int getBillAmount() {
        return billAmount;
    }


    public void UpdateBillAmount(TopUpPlan topUpPlan) {
        billAmount+=topUpPlan.getAmount()*devices;
    }

}
