package org.example.DoReMiSubscriptions.controller;

import org.example.DoReMiSubscriptions.constants.SubscriptionCategory;
import org.example.DoReMiSubscriptions.model.Subscription;
import org.example.DoReMiSubscriptions.model.SubscriptionPlan;
import org.example.DoReMiSubscriptions.model.TopUp;
import org.example.DoReMiSubscriptions.model.TopUpPlan;
import org.example.DoReMiSubscriptions.service.SubscriptionBillManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SubscriptionManager {
    private static final SubscriptionBillManagement subscriptionBillManagement= new SubscriptionBillManagement();
    public static String startDate;


    private static final List<Subscription> subscriptions = new ArrayList<>();
    static List<TopUp> topUp = new ArrayList<>();
    private static final Map<SubscriptionCategory, List<SubscriptionPlan>> subscriptionPlans = new HashMap<>();
    private static final Map<String, TopUpPlan> topUpPlan = new HashMap<>();



    static {
        subscriptionPlans.put(SubscriptionCategory.MUSIC, Arrays.asList(
                new SubscriptionPlan("FREE", 0, 0),
                new SubscriptionPlan("PERSONAL", 1, 100),
                new SubscriptionPlan("PREMIUM", 3, 250)));

        subscriptionPlans.put(SubscriptionCategory.VIDEO, Arrays.asList(
                new SubscriptionPlan("FREE", 0, 0),
                new SubscriptionPlan("PERSONAL", 1, 200),
                new SubscriptionPlan("PREMIUM", 3, 500)));

        subscriptionPlans.put(SubscriptionCategory.PODCAST, Arrays.asList(
                new SubscriptionPlan("FREE", 0, 0),
                new SubscriptionPlan("PERSONAL", 1, 100),
                new SubscriptionPlan("PREMIUM", 3, 300)));

        topUpPlan.put("FOUR_DEVICE", new TopUpPlan("FOUR_DEVICE", 4, 50));
        topUpPlan.put("TEN_DEVICE", new TopUpPlan("TEN_DEVICE", 10, 100));
    }


    private static void processCommand(String command) {
        String[] tokens = command.split(" ");
        String commandType = tokens[0];

        switch (commandType) {
            case "START_SUBSCRIPTION":
                startDate = tokens[1];
                break;
            case "ADD_SUBSCRIPTION":
                String category = tokens[1];
                for (Subscription subscription: subscriptions){
                    if(subscription.getCategory().equals(category)){

                    }
                }
                String planName = tokens[2];
                subscriptions.add(new Subscription(SubscriptionCategory.valueOf(category), planName));
                break;
            case "ADD_TOPUP":
                String topUpName = tokens[1];

                for (TopUp topUp1: topUp){
                    if(topUp1.getTopUpName().equals(topUpName)){

                    }
                }
                int months = Integer.parseInt(tokens[2]);
                topUp.add(new TopUp(topUpName, months));
                break;
            case "PRINT_RENEWAL_DETAILS":
                printRenewalDetails();
                break;
            default:
                System.out.println("Invalid command: " + commandType);
                break;
        }
    }

    private static void printRenewalDetails() {

        if(subscriptions.isEmpty() && topUp.isEmpty()){
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
            return;
        }

        if (subscriptions.isEmpty()) {
            System.out.println("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
            return;
        }

        if (topUp.isEmpty()) {
            System.out.println("INVALID_DATE");
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
            return;
        }

        int SubscriptionRenewalAmount = subscriptionBillManagement.calculateSubscriptionRenewalAmount(subscriptionPlans, subscriptions);
        int topUpRenewalAmount = subscriptionBillManagement.calculatetopUpRenewalAmount(topUpPlan, topUp);
        int totalRenewalAmount = SubscriptionRenewalAmount + topUpRenewalAmount;


        for (Subscription subscription: subscriptions) {
            System.out.println("RENEWAL_REMINDER " + subscription.getCategory() + " " + subscription.getRenewalDate());
        }

        System.out.println("RENEWAL_AMOUNT " + totalRenewalAmount);

    }



    public static void start(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                String commandType = tokens[0];
                if(commandType.equals("START_SUBSCRIPTION")){
                    startDate = tokens[1];
                }else if(commandType.equals("ADD_SUBSCRIPTION")) {
                    String category = tokens[1];
                    for (Subscription subscription : subscriptions) {
                        if (subscription.getCategory().equals(category)) {
                            System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
                            break;
                        }
                    }
                    String planName = tokens[2];
                    subscriptions.add(new Subscription(SubscriptionCategory.valueOf(category), planName));
                }else if (commandType.equals("ADD_TOPUP")) {
                    String topUpName = tokens[1];

                    for (TopUp topUp1 : topUp) {
                        if (topUp1.getTopUpName().equals(topUpName)) {
                            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
                            break;
                        }
                    }
                    int months = Integer.parseInt(tokens[2]);
                    topUp.add(new TopUp(topUpName, months));
                }else if (commandType.equals("PRINT_RENEWAL_DETAILS")) {
                    printRenewalDetails();
                }else{
                    System.out.println("Invalid command: " + commandType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



