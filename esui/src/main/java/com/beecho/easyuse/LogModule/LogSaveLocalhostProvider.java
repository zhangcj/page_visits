package com.beecho.easyuse.LogModule;

/**
 * Created by Administrator on 2017/7/5.
 */
public class LogSaveLocalhostProvider extends LogSaveProvider {
    @Override
    protected boolean isDoSaveLog(LogEntity entity) {
        System.out.println("11111111");
        return true;
    }
}
