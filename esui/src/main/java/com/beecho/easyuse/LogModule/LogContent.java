package com.beecho.easyuse.LogModule;

/**
 * Created by Administrator on 2017/7/5.
 * 日志内容
 */
public class LogContent {

    public LogContent(String logTrackInfo, String message) {
        this.logTrackInfo = logTrackInfo;
        this.message = message;
    }

    public String getLogTrackInfo() {
        return logTrackInfo;
    }

    public void setLogTrackInfo(String logTrackInfo) {
        this.logTrackInfo = logTrackInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String logTrackInfo;
    private String message;
}
