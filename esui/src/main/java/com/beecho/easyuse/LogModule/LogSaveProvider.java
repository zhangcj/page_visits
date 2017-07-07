package com.beecho.easyuse.LogModule;

/**
 * Created by Administrator on 2017/7/5.
 *
 * 提供程序基类，实现保存日志功能的抽象类
 *
 */
public abstract class LogSaveProvider implements ILogSaveProvider {

    @Override
    public boolean saveLog(LogEntity entity) {
        if(!this.validatorLogEntity(entity)) return false;
        return this.isDoSaveLog(this.formatLogContent(entity));
    }

    /**
     * 是否需要验证日志有效
     * @param entity
     * @return
     */
    protected boolean validatorLogEntity(LogEntity entity){
        return true;
    }

    /**
     * 格式化日志内容
     * @param entity
     * @return
     */
    protected LogEntity formatLogContent(LogEntity entity){
        return entity;
    }

    /**
     * 执行日志保存操作
     * @param entity
     * @return
     */
    protected abstract boolean isDoSaveLog(LogEntity entity);
}
