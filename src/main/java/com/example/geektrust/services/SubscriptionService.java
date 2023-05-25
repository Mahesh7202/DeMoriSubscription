package com.example.geektrust.services;

import com.example.geektrust.error.ErrorTracker;
import com.example.geektrust.error.ErrorHandler;
import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.SubscriptionPlan;
import com.example.geektrust.repository.SubscriptionPlanRepository;
import com.example.geektrust.repository.SubscriptionRepository;
import com.example.geektrust.repository.implementations.SubscriptionPlanRepositoryImpl;
import com.example.geektrust.repository.implementations.SubscriptionRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class SubscriptionService {
    private SubscriptionPlanRepository subscriptionPlanRepository;
    private SubscriptionRepository subscriptionRepository;

    private ErrorHandler errorHandler;

    public SubscriptionService() {
        this.subscriptionPlanRepository = new SubscriptionPlanRepositoryImpl();
        this.subscriptionRepository = new SubscriptionRepositoryImpl();
        this.errorHandler = ErrorTracker.getInstance();
    }

    public void addSubscription(String category, String planName, LocalDate startDate) {
        if (subscriptionRepository.findSubscriptionByCategory(category)) {
            errorHandler.handleDuplicateCategoryError();
        } else {
            SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.getAllSubscriptionPlanByCategoryAndPlanName(category, planName);
            String renewalDate = subscriptionRepository.calculateRenewalDate(startDate, subscriptionPlan);
            subscriptionRepository.addSubscription(new Subscription(category, subscriptionPlan, renewalDate));
        }
    }

    public List<Subscription> getSubscriptions() {
        return subscriptionRepository.getAllSubscriptions();
    }

    public int calculateSubscriptionRenewalAmount(List<Subscription> subscriptions, int totalBillAmount) {
        for (Subscription subscription : subscriptions) {
            SubscriptionPlan subscriptionPlan = subscription.getSubscriptionPlan();
            totalBillAmount = subscriptionRepository.calculateBillAmount(subscriptionPlan, totalBillAmount);
        }
        return totalBillAmount;
    }


}
