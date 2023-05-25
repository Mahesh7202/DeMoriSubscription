package com.example.geektrust.repository;

import com.example.geektrust.modal.TopUpPlan;

import java.util.Map;

public interface TopUpPlanRepository {

    Map<String, TopUpPlan> getTopUpPlans();

    TopUpPlan getTopUpPlanByMaxDevice(String maxDevice);

}
