package com.example.geektrust.repository;

import com.example.geektrust.modal.Subscription;
import com.example.geektrust.modal.SubscriptionPlan;
import com.example.geektrust.repository.interfaces.SubscriptionInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.example.geektrust.constants.Commands.DATE_FORMATTER;

public class SubscriptionRepository implements SubscriptionInterface {

    private List<Subscription> subscriptions;


    public SubscriptionRepository() {
        this.subscriptions = new ArrayList<>();
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }

    @Override
    public Boolean findSubscriptionByCategory(String category) {
        return subscriptions.stream()
                .anyMatch(subscription -> subscription.getSubscriptionCategory().equals(category));
    }

    @Override
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    @Override
    public String calculateRenewalDate(LocalDate startDate, SubscriptionPlan subscriptionPlan) {
        LocalDate renewalDate = startDate.plusMonths(subscriptionPlan.getDurationMonths()).minusDays(10);
        return renewalDate.format(DateTimeFormatter.ofPattern(DATE_FORMATTER.getValue()));
    }

    @Override
    public int calculateBillAmount(Subscription subscription, int billAmount){
        billAmount+=subscription.getBillAmount();
        return billAmount;

    }


    @Override
    public void updateBillAmount(Subscription subscription) {
        subscription.updateTotalBill(subscription.getSubscriptionPlan());
    }
}