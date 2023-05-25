package com.example.geektrust.initializers;

import com.example.geektrust.constants.Device;
import com.example.geektrust.modal.TopUpPlan;

import java.util.HashMap;
import java.util.Map;

import static com.example.geektrust.constants.Device.FOUR_DEVICE;
import static com.example.geektrust.constants.Device.TEN_DEVICE;


public class TopUpInitializer {

    private Map<String, TopUpPlan> topUpPlans;


    public TopUpInitializer() {
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

}
