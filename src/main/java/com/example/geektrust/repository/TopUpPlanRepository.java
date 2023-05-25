package com.example.geektrust.repository;

import com.example.geektrust.constants.Device;
import com.example.geektrust.modal.TopUpPlan;
import com.example.geektrust.repository.interfaces.TopUpPlanInterface;

import java.util.HashMap;
import java.util.Map;

import static com.example.geektrust.constants.Device.FOUR_DEVICE;
import static com.example.geektrust.constants.Device.TEN_DEVICE;

public class TopUpPlanRepository implements TopUpPlanInterface {
    private Map<String, TopUpPlan> topUpPlans;

    public TopUpPlanRepository() {
        this.topUpPlans = init();
    }

    public Map<String, TopUpPlan> init() {
        Map<String, TopUpPlan> topUpPlanMap = new HashMap<>();
        addTopUpPlans(topUpPlanMap);
        return topUpPlanMap;
    }

    private void addTopUpPlans(Map<String, TopUpPlan> topUpPlans) {
        topUpPlans.put(FOUR_DEVICE.getName(), createTopUpPlan(FOUR_DEVICE));
        topUpPlans.put(TEN_DEVICE.getName(), createTopUpPlan(TEN_DEVICE));
    }

    private TopUpPlan createTopUpPlan(Device deviceType) {
        return new TopUpPlan(deviceType.getName(), deviceType.getCount(), deviceType.getCost());
    }

    public Map<String, TopUpPlan> getTopUpPlans() {
        return topUpPlans;
    }

    public void updateTopUpPlanAmount(String topUpName, int newAmount) {
        TopUpPlan topUpPlan = topUpPlans.get(topUpName);
        if (topUpPlan != null) {
            topUpPlan.setAmount(newAmount);
        }
    }

    public TopUpPlan getTopUpPlanByMaxDevice(String maxDevices) {
        return topUpPlans.get(maxDevices);
    }
}
