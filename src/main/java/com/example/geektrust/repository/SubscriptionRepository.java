package com.example.geektrust.repository;

import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.SubscriptionPlan;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionRepository {

    List<Subscription> getAllSubscriptions();

    Boolean findSubscriptionByCategory(String category);

    void addSubscription(Subscription subscription);

    String calculateRenewalDate(LocalDate startDate, SubscriptionPlan subscriptionPlan);

    int calculateBillAmount(SubscriptionPlan subscriptionPlan, int totalBillAmount);
}
