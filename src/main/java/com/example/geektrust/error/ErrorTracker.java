package com.example.geektrust.error;

import java.time.LocalDate;

import static com.example.geektrust.constants.Status.NO_ERROR;


public class ErrorTracker extends ErrorHandler {
    private LocalDate startDate;



    private String error;

    private static final ErrorTracker instance = new ErrorTracker();

    private ErrorTracker() {
        this.startDate = LocalDate.now();
        this.error = NO_ERROR.getValue();
    }

    public static ErrorTracker getInstance() {
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
        return super.checkInvalidDate(getError());
    }
}
