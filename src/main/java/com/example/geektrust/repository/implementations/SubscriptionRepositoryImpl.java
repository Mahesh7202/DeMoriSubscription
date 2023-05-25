package com.example.geektrust.repository.implementations;

import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.SubscriptionPlan;
import com.example.geektrust.repository.SubscriptionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {


    private List<Subscription> subscriptions;
    private int totalBillAmount;

    public SubscriptionRepositoryImpl() {
        this.subscriptions = new ArrayList<>();
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }

    @Override
    public Boolean findSubscriptionByCategory(String category) {
        return subscriptions.stream()
                .anyMatch(
                        subscription -> subscription.
                                getSubscriptionCategory().toString().equals(category)
                );
    }

    @Override
    public void addSubscription(Subscription subscription){
        subscriptions.add(subscription);
    }

    @Override
    public String calculateRenewalDate(LocalDate startDate, SubscriptionPlan subscriptionPlan) {
        return subscriptionPlan.calculateRenewalDate(startDate, subscriptionPlan.getDurationMonths());
    }

    @Override
    public int calculateBillAmount(SubscriptionPlan subscriptionPlan, int totalBillAmount) {
        this.totalBillAmount = totalBillAmount + subscriptionPlan.getCost();
        return this.totalBillAmount;
    }

}
