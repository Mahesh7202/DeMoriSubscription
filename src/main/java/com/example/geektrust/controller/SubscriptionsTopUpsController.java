package com.example.geektrust.controller;

import com.example.geektrust.error.ExceptionHandler;
import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.TopUp;
import com.example.geektrust.services.SubscriptionService;
import com.example.geektrust.services.TopUpService;

import java.util.List;

public class SubscriptionsTopUpsController {



    private int totalBillAmount = 0;

    private SubscriptionService subscriptionService;
    private TopUpService topUpService;
    private ExceptionHandler exceptionHandler;

    public SubscriptionsTopUpsController(SubscriptionService subscriptionService, TopUpService topUpService, ExceptionHandler exceptionHandler) {
        this.subscriptionService = subscriptionService;
        this.topUpService = topUpService;
        this.exceptionHandler = exceptionHandler;
    }

    public int getTotalBillAmount() {
        return totalBillAmount;
    }

    private void updateTotalBill(int billAmount) {
        totalBillAmount+=billAmount;
    }

    public void addSubscription(String category, String planName) {
        if (exceptionHandler.isInvalidDate()) {
            exceptionHandler.handleInvalidDateErrorBySubscription();
        } else {
            subscriptionService.addSubscription(category, planName, exceptionHandler.getStartDate());
        }
    }

    public void addTopUp(String maxDevices, int months) {
        if (exceptionHandler.isInvalidDate()) {
            exceptionHandler.handleInvalidDateErrorByTopUP();
        } else {
            topUpService.addTopUp(maxDevices, months);
        }
    }

    public void printBill() {
        List<Subscription> subscriptions = subscriptionService.getSubscriptions();
        List<TopUp> topUps = topUpService.getTopUps();

        if (subscriptions.isEmpty() && topUps.isEmpty()) {
            exceptionHandler.handleNoSubscriptionsAndTopUpsError();
        } else if (subscriptions.isEmpty()) {
            exceptionHandler.handleNoSubscriptionsError();
        } else {
            printTotalBill(subscriptions, topUps);
        }
    }




    private void printTotalBill(List<Subscription> subscriptions, List<TopUp> topUps) {

        updateTotalBill(subscriptionService.calculateSubscriptionRenewalAmount(subscriptions));
        updateTotalBill(topUpService.calculateTopUpRenewalAmount(topUps));

        for (Subscription subscription : subscriptions) {
            System.out.println("RENEWAL_REMINDER " + subscription.getSubscriptionCategory() + " " + subscription.getRenewalDate());
        }
        System.out.println("RENEWAL_AMOUNT " + getTotalBillAmount());
    }


}
