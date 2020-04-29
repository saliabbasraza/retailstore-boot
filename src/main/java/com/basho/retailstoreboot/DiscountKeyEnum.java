package com.basho.retailstoreboot;

public enum DiscountKeyEnum {
    FLAT(Values.FLAT),
    AFFILIATE(Values.AFFILIATE),
    EMPLOYEE(Values.EMPLOYEE),
    LOYALTY(Values.LOYALTY);

    DiscountKeyEnum(String val) {
        // force equality between name of enum instance, and value of constant
        if (!this.name().equals(val))
            throw new IllegalArgumentException("Incorrect use of DiscountKeyEnum");
    }

    public static class Values {
        public static final String FLAT = "FLAT";
        public static final String AFFILIATE = "AFFILIATE";
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String LOYALTY = "LOYALTY";
    }
}
