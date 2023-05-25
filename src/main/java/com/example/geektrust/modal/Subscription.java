package com.example.geektrust.modal;


public class Subscription {
    private String subscriptionCategory;
    private SubscriptionPlan subscriptionPlan;
    private String renewalDate;

    private int billAmount;

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



    public void updateTotalBill(SubscriptionPlan subscriptionPlan) {
        int cost = subscriptionPlan.getCost();
        if (cost >= 0) {
            this.billAmount += cost;
        } else {
            throw new IllegalArgumentException("Invalid cost value: " + cost);
        }
    }

    public int getBillAmount() {
        return billAmount;
    }
}
