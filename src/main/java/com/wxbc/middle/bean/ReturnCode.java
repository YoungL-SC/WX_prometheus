package com.wxbc.middle.bean;

/**
 * Created by administrator on 17-9-19.
 */
public enum ReturnCode {
    CREATE_SUCCESS(1000);


    private int value;

    private ReturnCode(int value) {
        this.value = value;
    }

    public String getDesc() {
        switch (this) {
            case CREATE_SUCCESS:
                return "Create/Insert Success";
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }


}

