package com.example.geektrust.initializers;

import com.example.geektrust.constants.Category;
import com.example.geektrust.modal.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.geektrust.constants.Cost.*;
import static com.example.geektrust.constants.Durations.*;
import static com.example.geektrust.constants.Plan.*;

public class SubscriptionInitializer {

    private Map<String, List<SubscriptionPlan>> subscriptionPlans;

    public SubscriptionInitializer() {
        this.subscriptionPlans = init();
    }

    public Map<String, List<SubscriptionPlan>> init() {
        Map<String, List<SubscriptionPlan>> subscriptionCategoryListMap = new HashMap<>();
        addMusicSubscriptionPlans(subscriptionCategoryListMap);
        addPodcastSubscriptionPlans(subscriptionCategoryListMap);
        addVideoSubscriptionPlans(subscriptionCategoryListMap);
        return subscriptionCategoryListMap;
    }

    private void addMusicSubscriptionPlans(Map<String, List<SubscriptionPlan>> subscriptionPlans) {
        List<SubscriptionPlan> musicPlans = new ArrayList<>();
        musicPlans.add(new MusicSubscriptionPlan(FREE_PLAN.getValue(), FREE_DURATION.getValue(), FREE_COST.getValue()));
        musicPlans.add(new MusicSubscriptionPlan(PERSONAL_PLAN.getValue(), PERSONAL_DURATION.getValue(), PERSONAL_MUSIC_COST.getValue()));
        musicPlans.add(new MusicSubscriptionPlan(PREMIUM_PLAN.getValue(), PREMIUM_DURATION.getValue(), PREMIUM_MUSIC_COST.getValue()));
        subscriptionPlans.put(Category.MUSIC.getValue(), musicPlans);
    }

    private void addVideoSubscriptionPlans(Map<String, List<SubscriptionPlan>> subscriptionPlans) {
        List<SubscriptionPlan> videoPlans = new ArrayList<>();
        videoPlans.add(new VideoSubscriptionPlan(FREE_PLAN.getValue(), FREE_DURATION.getValue(), FREE_COST.getValue()));
        videoPlans.add(new VideoSubscriptionPlan(PERSONAL_PLAN.getValue(), PERSONAL_DURATION.getValue(), PERSONAL_VIDEO_COST.getValue()));
        videoPlans.add(new VideoSubscriptionPlan(PREMIUM_PLAN.getValue(), PREMIUM_DURATION.getValue(), PREMIUM_VIDEO_COST.getValue()));
        subscriptionPlans.put(Category.VIDEO.getValue(), videoPlans);
    }

    private void addPodcastSubscriptionPlans(Map<String, List<SubscriptionPlan>> subscriptionPlans) {
        List<SubscriptionPlan> podcastPlans = new ArrayList<>();
        podcastPlans.add(new PodcastSubscriptionPlan(FREE_PLAN.getValue(), FREE_DURATION.getValue(), FREE_COST.getValue()));
        podcastPlans.add(new PodcastSubscriptionPlan(PERSONAL_PLAN.getValue(), PERSONAL_DURATION.getValue(), PERSONAL_PODCAST_COST.getValue()));
        podcastPlans.add(new PodcastSubscriptionPlan(PREMIUM_PLAN.getValue(), PREMIUM_DURATION.getValue(), PREMIUM_PODCAST_COST.getValue()));
        subscriptionPlans.put(Category.PODCAST.getValue(), podcastPlans);
    }

    public Map<String, List<SubscriptionPlan>> getSubscriptionPlans() {
        return subscriptionPlans;
    }
}
