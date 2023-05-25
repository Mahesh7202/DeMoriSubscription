package com.example.geektrust.controller;


import com.example.geektrust.error.ExceptionHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.example.geektrust.constants.Commands.*;
import static com.example.geektrust.constants.Status.NO_ERROR;

public class SubscriptionBillController {

    private SubscriptionsTopUpsController subscriptionsTopUpsController;
    private ExceptionHandler exceptionHandler;

    public SubscriptionBillController(SubscriptionsTopUpsController subscriptionsTopUpsController, ExceptionHandler exceptionHandler) {
        this.subscriptionsTopUpsController = subscriptionsTopUpsController;
        this.exceptionHandler = exceptionHandler;

    }
    public void processCommand(String[] tokens) {
        if (tokens[0].equals(START_SUBSCRIPTION.getValue())) {
            try {

                LocalDate startDate = LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern(DATE_FORMATTER.getValue()));
                exceptionHandler.setStartDate(startDate);
                exceptionHandler.setError(NO_ERROR.getValue());
            } catch (DateTimeParseException e) {
                System.out.println(INVALID_DATE.getValue());
                exceptionHandler.setError(String.valueOf(INVALID_DATE.getValue()));
            }
        } else if (tokens[0].equals(ADD_SUBSCRIPTION.getValue())) {
            subscriptionsTopUpsController.addSubscription(tokens[1], tokens[2]);
        } else if (tokens[0].equals(ADD_TOPUP.getValue())) {
            subscriptionsTopUpsController.addTopUp(tokens[1], Integer.parseInt(tokens[2]));
        } else if (tokens[0].equals(PRINT_RENEWAL_DETAILS.getValue())) {
            printBill();
        }else{
            System.out.println("No Command Found!");
        }
    }


    public void printBill () {
        if (exceptionHandler.isInvalidDate()) {
            exceptionHandler.handleInValidDateErrorBySubscriptionBill();
        } else {
            subscriptionsTopUpsController.printBill();
        }
    }
}

