package com.example.geektrust.services;
import com.example.geektrust.error.ExceptionHandler;
import com.example.geektrust.repository.interfaces.SubscriptionPlanInterface;
import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.SubscriptionPlan;
import com.example.geektrust.repository.interfaces.SubscriptionInterface;

import java.time.LocalDate;
import java.util.List;

public class SubscriptionService {

    private SubscriptionPlanInterface subscriptionPlanInterface;

    private SubscriptionInterface subscriptionInterface;
    private ExceptionHandler exceptionHandler;


    public SubscriptionService(SubscriptionInterface subscriptionInterface, SubscriptionPlanInterface subscriptionPlanInterface, ExceptionHandler exceptionHandler) {
        this.subscriptionInterface = subscriptionInterface;
        this.exceptionHandler = exceptionHandler;
        this.subscriptionPlanInterface = subscriptionPlanInterface;
    }
    public void addSubscription(String category, String planName, LocalDate startDate) {
        if (subscriptionInterface.findSubscriptionByCategory(category)) {
            exceptionHandler.handleDuplicateCategoryError();
        } else {
            SubscriptionPlan subscriptionPlan = subscriptionPlanInterface.getSubscriptionPlanByCategoryAndPlanName(category, planName);
            if (subscriptionPlan == null) {
                exceptionHandler.handleInvalidPlanError();
            } else {
                String renewalDate = subscriptionInterface.calculateRenewalDate(startDate, subscriptionPlan);
                Subscription subscription = new Subscription(category, subscriptionPlan, renewalDate);
                subscriptionInterface.addSubscription(subscription);
                subscriptionInterface.updateBillAmount(subscription);
            }
        }
    }

    public List<Subscription> getSubscriptions() {
        return subscriptionInterface.getAllSubscriptions();
    }

    public int calculateSubscriptionRenewalAmount(List<Subscription> subscriptions) {
        int totalBillAmount = 0;
        for(Subscription subscription: subscriptions){
            totalBillAmount = subscriptionInterface.calculateBillAmount(subscription, totalBillAmount);
        }
        return totalBillAmount;
    }
}