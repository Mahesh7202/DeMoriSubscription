package com.example.geektrust.repository;

import com.example.geektrust.modal.TopUp;
import com.example.geektrust.repository.interfaces.TopUpInterface;

import java.util.ArrayList;
import java.util.List;

public class TopUpRepository implements TopUpInterface {

    private List<TopUp> topUps;
    private int totalBillAmount;

    public TopUpRepository() {
        this.topUps = new ArrayList<>();
        this.totalBillAmount = 0;
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
    public int calculateBillAmount(TopUp topUp, int currentBillAmount) {
        return  topUp.getBillAmount();
    }

    @Override
    public void updateBillAmount(TopUp topUp) {
        topUp.UpdateBillAmount(topUp.getTopUpPlan());
    }

    public int getTotalBillAmount() {
        return totalBillAmount;
    }
}
