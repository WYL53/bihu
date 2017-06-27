package com.wyl.bihu.Model;

/**
 * Created by Administrator on 2017/6/26.
 */
public enum ResponseStatus {

    OK(0),
    FAIL(1);
    private int status;
    ResponseStatus(int status){
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(status);
    }
}
