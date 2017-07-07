package com.beecho.easyuse.Request;

/**
 * Created by Administrator on 2017/7/5.
 *
 * 请求上下文
 */
public class RequestContext {

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String format;
    private int size;
    private RequestProtocol protocol;
    private String content;
}
