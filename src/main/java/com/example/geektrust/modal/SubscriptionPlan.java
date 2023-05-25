package com.example.geektrust.modal;

public class SubscriptionPlan {
    private String planName;
    private int durationMonths;
    private int cost;

    public SubscriptionPlan(String planName, int durationMonths, int cost) {
        this.planName = planName;
        this.durationMonths = durationMonths;
        this.cost = cost;
    }

    public String getPlanName() {
        return planName;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public int getCost() {
        return cost;
    }

    public boolean hasPlanName(String planName) {
        return this.planName.equals(planName);
    }
}
