package com.example.geektrust.services;

import com.example.geektrust.error.ExceptionHandler;
import com.example.geektrust.repository.interfaces.TopUpPlanInterface;
import com.example.geektrust.modal.TopUp;
import com.example.geektrust.modal.TopUpPlan;
import com.example.geektrust.repository.interfaces.TopUpInterface;

import java.util.List;

public class TopUpService {

    private TopUpPlanInterface topUpPlanInterface;
    private TopUpInterface topUpInterface;
    private ExceptionHandler exceptionHandler;

    public TopUpService(TopUpInterface topUpInterface, TopUpPlanInterface topUpPlanInterface, ExceptionHandler exceptionHandler) {
        this.topUpInterface = topUpInterface;
        this.topUpPlanInterface = topUpPlanInterface;
        this.exceptionHandler = exceptionHandler ;
    }

    public void addTopUp(String maxDevices, int months) {
        if (!topUpInterface.getAllTopUps().isEmpty()) {
            exceptionHandler.handleDuplicateTopUpError();
        } else {
            TopUpPlan topUpPlan = topUpPlanInterface.getTopUpPlanByMaxDevice(maxDevices);
            TopUp topUp = new TopUp(topUpPlan, months);
            topUpInterface.addTopUp(topUp);
            topUpInterface.updateBillAmount(topUp);
        }
    }

    public List<TopUp> getTopUps() {
        return topUpInterface.getAllTopUps();
    }

    public int calculateTopUpRenewalAmount(List<TopUp> topUps) {
        int totalBillAmount = 0;
        for (TopUp topUp : topUps) {
            totalBillAmount = topUpInterface.calculateBillAmount(topUp, totalBillAmount);
        }
        return totalBillAmount;
    }
}
