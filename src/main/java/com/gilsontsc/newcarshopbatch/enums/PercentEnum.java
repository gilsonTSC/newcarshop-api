package com.gilsontsc.newcarshopbatch.enums;

public enum PercentEnum {
    P_02("0.02"),
    P_05("0.05"),
    P_10("0.1"),
    P_15("0.15"),
    P_25("0.25"),
    P_100("1.0");

    private String percent;

    PercentEnum(String percent) {
        this.percent = percent;
    }

    public String getPercent() {
        return percent;
    }
}
