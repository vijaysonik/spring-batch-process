package com.netpay.SpringBatchProcess.util;

/**
 * Enum for Status : 0 , 1
 */
public enum StatusEnum {
    ZERO(0),
    ONE(1);

    public final int status;

    private StatusEnum(int status) {
        this.status = status;
    }

}
