package org.example.DoReMiSubscriptions.model;

public class SubscriptionPlan {
    private String planName;
    private int durationMonths;
    private int amount;

    public SubscriptionPlan(String planName, int durationMonths, int amount) {
        this.planName = planName;
        this.durationMonths = durationMonths;
        this.amount = amount;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
