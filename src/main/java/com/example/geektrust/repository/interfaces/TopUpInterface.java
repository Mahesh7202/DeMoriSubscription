package com.example.geektrust.repository.interfaces;

import com.example.geektrust.modal.TopUp;

import java.util.List;

public interface TopUpInterface {

    List<TopUp> getAllTopUps();

    void addTopUp(TopUp topUp);


    int calculateBillAmount(TopUp topUp, int currentBillAmount);

    void updateBillAmount(TopUp topUp);
}
