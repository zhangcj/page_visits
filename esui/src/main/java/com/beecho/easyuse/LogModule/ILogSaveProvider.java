package com.beecho.easyuse.LogModule;

/**
 * Created by Administrator on 2017/7/5.
 *
 * 日志保存接口
 */
public interface ILogSaveProvider {

    /**
     * 保存日志
     * @param entity
     * @return
     */
    boolean saveLog(LogEntity entity);
}
