package com.beecho.easyuse.Request;

/**
 * Created by Administrator on 2017/7/5.
 */
public class RequestConfigManager {

    public static RequestConfigManager manager = new RequestConfigManager();

    /**
     * 格式化为json
     * @return
     */
    public RequestConfigManager setGloableRequestFormatJson(){
        if(RequestConfigContext.configContext.getFormal() != null
                && RequestConfigContext.configContext.getFormal()!=""){
            RequestConfigContext.configContext.setFormal("json");
        }
        return this;
    }

    /**
     * 设置大小
     * @param size
     * @return
     */
    public RequestConfigManager setGloableRequestSize(int size){
        RequestConfigContext.configContext.setSize(size);
        return this;
    }

    /**
     * 设置协议
     * @param protocol
     * @return
     */
    public RequestConfigManager setGloableRequestProtocol(RequestProtocol protocol){
        RequestConfigContext.configContext.setProtocol(protocol);
        return this;
    }
}
