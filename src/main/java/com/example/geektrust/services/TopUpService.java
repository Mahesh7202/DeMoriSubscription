package com.example.geektrust.services;

import com.example.geektrust.error.ErrorTracker;
import com.example.geektrust.error.ErrorHandler;
import com.example.geektrust.modal.TopUp;
import com.example.geektrust.modal.TopUpPlan;
import com.example.geektrust.repository.TopUpPlanRepository;
import com.example.geektrust.repository.TopUpRepository;
import com.example.geektrust.repository.implementations.TopUpPlanRepositoryImpl;
import com.example.geektrust.repository.implementations.TopUpRepositoryImpl;

import java.util.List;

public class TopUpService extends ErrorHandler {

    private TopUpRepository topUpRepository;
    private TopUpPlanRepository topUpPlanRepository;

    private ErrorHandler errorHandler;

    public TopUpService() {
        this.topUpRepository = new TopUpRepositoryImpl();
        this.topUpPlanRepository = new TopUpPlanRepositoryImpl();
        this.errorHandler = ErrorTracker.getInstance();
    }

    public void addTopUp(String maxDevices, int months) {
        if (!topUpRepository.getAllTopUps().isEmpty()) {
            errorHandler.handleDuplicateTopUpError();
        } else {
            TopUpPlan topUpPlan = topUpPlanRepository.getTopUpPlanByMaxDevice(maxDevices);
            topUpRepository.addTopUp(new TopUp(topUpPlan, months));
        }
    }



    public List<TopUp> getTopUps() {
        return topUpRepository.getAllTopUps();
    }

    public int calculateTopUpRenewalAmount(List<TopUp> topUps, int totalBillAmount) {
        for (TopUp topUp : topUps) {
            TopUpPlan topUpPlan = topUp.getTopUpPlan();
            totalBillAmount = topUpRepository.calculateBillAmount(topUpPlan, topUp.getDevices(), totalBillAmount);
        }
        return totalBillAmount;
    }

}
