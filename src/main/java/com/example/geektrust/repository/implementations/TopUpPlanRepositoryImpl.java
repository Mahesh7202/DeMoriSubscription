package com.example.geektrust.repository.implementations;

import com.example.geektrust.initializers.TopUpInitializer;
import com.example.geektrust.modal.TopUpPlan;
import com.example.geektrust.repository.TopUpPlanRepository;

import java.util.Map;

public class TopUpPlanRepositoryImpl extends TopUpInitializer implements TopUpPlanRepository {

    private TopUpInitializer topUpInitializer;

    public TopUpPlanRepositoryImpl() {
        this.topUpInitializer = new TopUpInitializer();
    }


    @Override
    public Map<String, TopUpPlan> getTopUpPlans() {
        return topUpInitializer.getTopUpPlans();
    }

    @Override
    public TopUpPlan getTopUpPlanByMaxDevice(String maxDevice) {
        return getTopUpPlans().get(maxDevice);
    }



}
