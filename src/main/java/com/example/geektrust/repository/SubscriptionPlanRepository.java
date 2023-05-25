package com.example.geektrust.repository;

import com.example.geektrust.modal.SubscriptionPlan;

import java.util.List;
import java.util.Map;

public interface SubscriptionPlanRepository {

     Map<String, List<SubscriptionPlan>> getAllSubscriptionPlans();

     SubscriptionPlan getAllSubscriptionPlanByCategoryAndPlanName(String category, String planName);

}
