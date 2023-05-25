package com.example.geektrust.controller;

import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.TopUp;
import com.example.geektrust.services.SubscriptionService;
import com.example.geektrust.services.TopUpService;
import com.example.geektrust.error.ErrorTracker;

import java.util.List;



public class SubscriptionsTopUpsController {

    private SubscriptionService subscriptionService;
    private TopUpService topUpService;
    private ErrorTracker errorTracker;


    public SubscriptionsTopUpsController(ErrorTracker errorTracker) {
        this.subscriptionService = new SubscriptionService();
        this.topUpService = new TopUpService();
        this.errorTracker = errorTracker;
    }


    void addSubscription(String category, String planName) {
        if (errorTracker.isInvalidDate()) {
            errorTracker.handleInvalidDateErrorBySubscription();
        } else {
            subscriptionService.addSubscription(category, planName, errorTracker.getStartDate());
        }
    }

    void addTopUp(String category, int amount) {
        if (errorTracker.isInvalidDate()) {
            errorTracker.handleInvalidDateErrorByTopUP();
        } else {
            topUpService.addTopUp(category, amount);
        }
    }


    public void printBill() {
        List<Subscription> subscriptions = subscriptionService.getSubscriptions();
        List<TopUp> topUps = topUpService.getTopUps();

        if (subscriptions.isEmpty() && topUps.isEmpty()) {
            errorTracker.handleNoSubscriptionsAndTopUpsError();
        } else if (subscriptions.isEmpty()) {
            errorTracker.handleNoSubscriptionsError();
        } else {
            printTotalBill(subscriptions, topUps);
        }
    }


    private void printTotalBill(List<Subscription> subscriptions, List<TopUp> topUps) {
        int totalBillAmount = 0;
        int totalRenewalAmount = subscriptionService.calculateSubscriptionRenewalAmount(subscriptions, totalBillAmount)
                + topUpService.calculateTopUpRenewalAmount(topUps, totalBillAmount);

        for (Subscription subscription : subscriptions) {
            System.out.println("RENEWAL_REMINDER " + subscription.getSubscriptionCategory() + " " + subscription.getRenewalDate());
        }
        System.out.println("RENEWAL_AMOUNT " + totalRenewalAmount);
    }
}



