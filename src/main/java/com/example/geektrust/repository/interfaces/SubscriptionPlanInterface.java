package com.example.geektrust.repository.interfaces;

import com.example.geektrust.modal.SubscriptionPlan;

import java.util.List;
import java.util.Map;

public interface SubscriptionPlanInterface {

     Map<String, List<SubscriptionPlan>> getAllSubscriptionPlans();


    SubscriptionPlan getSubscriptionPlanByCategoryAndPlanName(String category, String planName);
}
