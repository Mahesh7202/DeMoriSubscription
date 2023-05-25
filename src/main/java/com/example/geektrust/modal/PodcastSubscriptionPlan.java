package com.example.geektrust.modal;

import com.example.geektrust.constants.Category;

public class PodcastSubscriptionPlan extends SubscriptionPlan {

    public PodcastSubscriptionPlan(String planName, int durationMonths, int cost) {
        super(planName, durationMonths, cost);
    }

    @Override
    public String getCategory() {
        return Category.PODCAST.getValue();
    }
}
