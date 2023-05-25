package com.example.geektrust.modal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.geektrust.constants.Commands.DATE_FORMATTER;

public abstract class SubscriptionPlan {
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

    public abstract String getCategory();

    public String calculateRenewalDate(LocalDate startDate, int durationMonths) {
        LocalDate localDate = startDate.plusMonths(durationMonths);
        localDate = localDate.minusDays(10);
        String renewableDate = localDate.format(DateTimeFormatter.ofPattern(DATE_FORMATTER.getValue()));
        return renewableDate;
    }


    public boolean hasPlanName(String planName) {
        return getPlanName().equals(planName);
    }
}
