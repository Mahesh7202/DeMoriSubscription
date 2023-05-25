package com.example.geektrust.repository.interfaces;

import com.example.geektrust.modal.TopUpPlan;

import java.util.Map;

public interface TopUpPlanInterface {

    Map<String, TopUpPlan> getTopUpPlans();

    TopUpPlan getTopUpPlanByMaxDevice(String maxDevice);

}
