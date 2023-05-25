package com.example.geektrust.repository.implementations;

import com.example.geektrust.initializers.TopUpInitializer;
import com.example.geektrust.modal.TopUp;
import com.example.geektrust.modal.TopUpPlan;
import com.example.geektrust.repository.TopUpRepository;

import java.util.ArrayList;
import java.util.List;

public class TopUpRepositoryImpl implements TopUpRepository {

    private List<TopUp> topUps;

    private int totalBillAmount;

    public TopUpRepositoryImpl() {
        this.topUps = new ArrayList<>();
    }

    @Override
    public List<TopUp> getAllTopUps() {
        return topUps;
    }

    @Override
    public void addTopUp(TopUp topUp) {
        topUps.add(topUp);
    }

    @Override
    public int calculateBillAmount(TopUpPlan topUpPlan, int deviceCount, int totalBillAmount) {
        this.totalBillAmount = totalBillAmount + topUpPlan.getAmount() * deviceCount;
        return this.totalBillAmount;
    }
}
