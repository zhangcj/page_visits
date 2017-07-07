package com.beecho.easyuse.Request;

/**
 * Created by Administrator on 2017/7/5.
 *
 * 可通过构造方法定义自己的协议
 */
public class RequestProtocol {
    public static final String Soap = "Soap";
    public static final String InternalSoa = "Soa";

    private String protocol;

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public RequestProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }
}
