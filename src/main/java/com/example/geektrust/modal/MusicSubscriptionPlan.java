package com.example.geektrust.modal;

import com.example.geektrust.constants.Category;

import java.time.LocalDate;

public class MusicSubscriptionPlan extends SubscriptionPlan{
    public MusicSubscriptionPlan(String planName, int durationMonths, int amount) {
        super(planName, durationMonths, amount);
    }

    @Override
    public String getCategory() {
        return Category.MUSIC.getValue();
    }
}
