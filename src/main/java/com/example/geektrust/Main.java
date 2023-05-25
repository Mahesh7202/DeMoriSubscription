package com.example.geektrust;


import com.example.geektrust.controller.SubscriptionBillController;
import com.example.geektrust.controller.SubscriptionsTopUpsController;

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
        SubscriptionBillController subscriptionBillController = new SubscriptionBillController();
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



