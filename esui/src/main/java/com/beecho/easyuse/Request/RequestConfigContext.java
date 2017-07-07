package com.beecho.easyuse.Request;

/**
 * Created by Administrator on 2017/7/5.
 */
public class RequestConfigContext {
    public static RequestConfigContext configContext = new RequestConfigContext();

    public String getFormal() {
        return formal;
    }

    public void setFormal(String formal) {
        this.formal = formal;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RequestProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(RequestProtocol protocol) {
        this.protocol = protocol;
    }

    // 请求内容格式
    private String formal;

    // 请求上下文固定大小，不能超过这个设置
    private int size;

    // 协议类型
    private RequestProtocol protocol;
}
