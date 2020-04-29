package com.basho.retailstoreboot;

public enum DiscountTypeEnum {
    CUSTOM(DiscountTypeEnum.Values.CUSTOM),
    PERCENTAGE(DiscountTypeEnum.Values.PERCENTAGE);

    DiscountTypeEnum(String val) {
        // force equality between name of enum instance, and value of constant
        if (!this.name().equals(val))
            throw new IllegalArgumentException("Incorrect use of DiscountKeyEnum");
    }

    public static class Values {
        public static final String CUSTOM = "CUSTOM";
        public static final String PERCENTAGE = "PERCENTAGE";
    }
}
