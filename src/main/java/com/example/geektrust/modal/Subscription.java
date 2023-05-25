package com.example.geektrust.modal;


public class Subscription {

    private String subscriptionCategory;
    private SubscriptionPlan subscriptionPlan;
    private String renewalDate;


    public Subscription(String subscriptionCategory, SubscriptionPlan subscriptionPlan, String renewalDate) {
        this.subscriptionCategory = subscriptionCategory;
        this.subscriptionPlan = subscriptionPlan;
        this.renewalDate = renewalDate;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public String getSubscriptionCategory() {
        return subscriptionCategory;
    }

    public String getRenewalDate() {
        return renewalDate;
    }

}
