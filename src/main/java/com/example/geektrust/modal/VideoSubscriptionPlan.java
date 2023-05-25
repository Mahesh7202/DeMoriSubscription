package com.example.geektrust.modal;

import com.example.geektrust.constants.Category;


public class VideoSubscriptionPlan extends SubscriptionPlan{
    public VideoSubscriptionPlan(String planName, int durationMonths, int amount) {
        super(planName, durationMonths, amount);
    }

    @Override
    public String getCategory() {
        return Category.VIDEO.getValue();
    }


}
