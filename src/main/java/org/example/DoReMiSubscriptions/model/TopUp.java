package org.example.DoReMiSubscriptions.model;

public class TopUp {
    private String topUpName;
    private int devices;

    public TopUp(String topUpName, int devices) {
        this.topUpName = topUpName;
        this.devices = devices;
    }

    public String getTopUpName() {
        return topUpName;
    }

    public void setTopUpName(String topUpName) {
        this.topUpName = topUpName;
    }

    public int getDevices() {
        return devices;
    }

    public void setDevices(int devices) {
        this.devices = devices;
    }
}