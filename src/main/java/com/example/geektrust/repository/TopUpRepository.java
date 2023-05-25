package com.example.geektrust.repository;

import com.example.geektrust.modal.TopUp;
import com.example.geektrust.modal.TopUpPlan;

import java.util.List;

public interface TopUpRepository {

    List<TopUp> getAllTopUps();

    void addTopUp(TopUp topUp);

    int calculateBillAmount(TopUpPlan topUpPlan, int deviceCount, int totalBillAmount);
}
