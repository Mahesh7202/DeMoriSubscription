package com.example.geektrust.modal;

import com.example.geektrust.repository.TopUpRepository;

import java.util.ArrayList;
import java.util.List;

public class TopUp {


    private TopUpPlan topUpPlan;
    private int devices;


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

}
