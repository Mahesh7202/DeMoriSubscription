package com.example.geektrust.error;

import java.time.LocalDate;

import static com.example.geektrust.constants.Status.*;

public class ExceptionHandler  {
        private LocalDate startDate;
        private String error;

        private static final ExceptionHandler instance = new ExceptionHandler();

        private ExceptionHandler() {
            this.startDate = LocalDate.now();
            this.error = NO_ERROR.getValue();
        }

        public static ExceptionHandler getInstance() {
            return instance;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }


        public boolean isInvalidDate() {
            return getError().equals(ERROR_INVALID_DATE.getValue());
        }




    public void handleInvalidDateErrorBySubscription() {
        System.out.println(ADD_SUBSCRIPTION_FAILED_INVALID_DATE.getValue());
    }

    public void handleInvalidDateErrorByTopUP(){
        System.out.println(ADD_TOPUP_FAILED_INVALID_DATE.getValue());
    }


    public void handleNoSubscriptionsAndTopUpsError() {
        System.out.println(SUBSCRIPTIONS_NOT_FOUND.getValue());
    }
    public void handleDuplicateTopUpError() {
        System.out.println(ADD_TOPUP_FAILED_DUPLICATE_TOPUP.getValue());
    }


    public void handleDuplicateCategoryError() {
        System.out.println(ADD_SUBSCRIPTION_FAILED_DUPLICATE_CATEGORY.getValue());
    }


    public void handleNoSubscriptionsError() {
        System.out.println(ADD_TOPUP_FAILED_SUBSCRIPTIONS_NOT_FOUND.getValue());
        System.out.println(SUBSCRIPTIONS_NOT_FOUND.getValue());
    }


    public void handleInValidDateErrorBySubscriptionBill() {
        System.out.println(SUBSCRIPTIONS_NOT_FOUND.getValue());
    }

    public boolean checkInvalidDate(String error) {
        String errorInvalidDateValue = ERROR_INVALID_DATE.getValue();
        return errorInvalidDateValue.equals(error);
    }


    public void handleInvalidPlanError() {
    }
}
