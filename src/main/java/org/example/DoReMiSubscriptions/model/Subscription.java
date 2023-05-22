package org.example.DoReMiSubscriptions.model;

import org.example.DoReMiSubscriptions.constants.SubscriptionCategory;

public class Subscription {
    private SubscriptionCategory category;
    private String planName;
    private String renewalDate;

    public Subscription(SubscriptionCategory category, String planName) {
        this.category = category;
        this.planName = planName;
        this.renewalDate = renewalDate;
    }

    public void setCategory(SubscriptionCategory category) {
        this.category = category;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setRenewalDate(String renewalDate) {
        this.renewalDate = renewalDate;
    }

    public SubscriptionCategory getCategory() {
        return category;
    }

    public String getPlanName() {
        return planName;
    }

    public String getRenewalDate() {
        return renewalDate;
    }
}
