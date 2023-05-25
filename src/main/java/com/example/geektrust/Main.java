package com.example.geektrust;

import com.example.geektrust.controller.SubscriptionBillController;
import com.example.geektrust.controller.SubscriptionsTopUpsController;
import com.example.geektrust.error.ExceptionHandler;
import com.example.geektrust.repository.interfaces.SubscriptionInterface;
import com.example.geektrust.repository.interfaces.SubscriptionPlanInterface;
import com.example.geektrust.repository.interfaces.TopUpInterface;
import com.example.geektrust.repository.interfaces.TopUpPlanInterface;
import com.example.geektrust.repository.SubscriptionPlanRepository;
import com.example.geektrust.repository.TopUpPlanRepository;
import com.example.geektrust.repository.SubscriptionRepository;
import com.example.geektrust.repository.TopUpRepository;
import com.example.geektrust.services.SubscriptionService;
import com.example.geektrust.services.TopUpService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start(args[0]);
    }

    public static void start(String filename) {
        SubscriptionInterface subscriptionInterface = new SubscriptionRepository();
        SubscriptionPlanInterface subscriptionPlanInterface = new SubscriptionPlanRepository();
        TopUpInterface topUpInterface = new TopUpRepository();
        TopUpPlanInterface topUpPlanInterface = new TopUpPlanRepository();
        ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
        SubscriptionService subscriptionService = new SubscriptionService(subscriptionInterface, subscriptionPlanInterface, exceptionHandler);
        TopUpService topUpService = new TopUpService(topUpInterface, topUpPlanInterface, exceptionHandler);
        SubscriptionsTopUpsController subscriptionsTopUpsController = new SubscriptionsTopUpsController(subscriptionService, topUpService, exceptionHandler);
        SubscriptionBillController subscriptionBillController = new SubscriptionBillController(subscriptionsTopUpsController, exceptionHandler);

        try {
            List<String> lines = readFile(filename);
            for (String line : lines) {
                subscriptionBillController.processCommand(line.split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (FileInputStream reader = new FileInputStream(filename);
             Scanner sc = new Scanner(reader)) {
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        }
        return lines;
    }
}
