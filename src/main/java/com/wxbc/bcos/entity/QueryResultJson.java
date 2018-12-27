package com.wxbc.bcos.entity;

public class QueryResultJson {

    private int ret;
    private com.wxbc.bcos.entity.DataJson data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public com.wxbc.bcos.entity.DataJson getData() {
        return data;
    }

    public void setData(DataJson data) {
        this.data = data;
    }
}
