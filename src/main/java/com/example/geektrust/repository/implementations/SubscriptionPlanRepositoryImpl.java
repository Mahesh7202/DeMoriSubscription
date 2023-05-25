package com.example.geektrust.repository.implementations;

import com.example.geektrust.initializers.SubscriptionInitializer;
import com.example.geektrust.modal.SubscriptionPlan;
import com.example.geektrust.repository.SubscriptionPlanRepository;

import java.util.List;
import java.util.Map;

public class SubscriptionPlanRepositoryImpl extends SubscriptionInitializer implements SubscriptionPlanRepository {

    private SubscriptionInitializer subscriptionInitializer;

    public SubscriptionPlanRepositoryImpl() {
        this.subscriptionInitializer = new SubscriptionInitializer();
    }


    @Override
    public Map<String, List<SubscriptionPlan>> getAllSubscriptionPlans() {
        return subscriptionInitializer.getSubscriptionPlans();
    }

    @Override
    public SubscriptionPlan getAllSubscriptionPlanByCategoryAndPlanName(String category, String planName) {
        List<SubscriptionPlan> subscriptionPlans = getAllSubscriptionPlanByCategory(category);
        return getSubscriptionPlanByPlanName(planName, subscriptionPlans);
    }

    public List<SubscriptionPlan> getAllSubscriptionPlanByCategory(String category) {
        Map<String, List<SubscriptionPlan>> stringListMap = getAllSubscriptionPlans();
        return stringListMap.get(category);
    }

    public SubscriptionPlan getSubscriptionPlanByPlanName(String planName, List<SubscriptionPlan> subscriptionPlans){
        return subscriptionPlans.stream().filter(
                subscriptionPlan -> subscriptionPlan.hasPlanName(planName)
        ).findFirst().orElse(null);
    }


}
