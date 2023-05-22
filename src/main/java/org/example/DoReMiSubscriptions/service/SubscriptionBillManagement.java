package org.example.DoReMiSubscriptions.service;

import org.example.DoReMiSubscriptions.constants.SubscriptionCategory;
import org.example.DoReMiSubscriptions.controller.SubscriptionManager;
import org.example.DoReMiSubscriptions.model.Subscription;
import org.example.DoReMiSubscriptions.model.SubscriptionPlan;
import org.example.DoReMiSubscriptions.model.TopUp;
import org.example.DoReMiSubscriptions.model.TopUpPlan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class SubscriptionBillManagement {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");;

    public SubscriptionBillManagement() {}

    public static String calculateRenewalDate(int durationMonths) {
        LocalDate initialDate = LocalDate.parse(SubscriptionManager.startDate, DATE_FORMATTER);
        LocalDate renewalDate = initialDate.plusMonths(durationMonths).minusDays(10);;
        return  renewalDate.format(DATE_FORMATTER);

    }

    public int calculateSubscriptionRenewalAmount(Map<SubscriptionCategory, List<SubscriptionPlan>> subscriptionPlans, List<Subscription> subscriptions) {
        int subscriptionRenewalAmount = 0;
        for(Subscription subscription: subscriptions){
            List<SubscriptionPlan> subscriptionPlan = subscriptionPlans.get(subscription.getCategory());

            for(SubscriptionPlan subscriptionPlan1: subscriptionPlan)
                if(subscriptionPlan1.getPlanName().equals(subscription.getPlanName())){
                    subscription.setRenewalDate(calculateRenewalDate(subscriptionPlan1.getDurationMonths()));
                    subscriptionRenewalAmount+=subscriptionPlan1.getAmount();
                }

        }

        return subscriptionRenewalAmount;

    }

    public int calculatetopUpRenewalAmount(Map<String, TopUpPlan> topUpPlans, List<TopUp> topUps) {
        int topUpRenewalAmount = 0;
        for(TopUp topUp: topUps){
            TopUpPlan topUpPlan = topUpPlans.get(topUp.getTopUpName());
            topUpRenewalAmount += topUpPlan.getAmount()*topUp.getDevices();
        }
        return topUpRenewalAmount;
    }
}
