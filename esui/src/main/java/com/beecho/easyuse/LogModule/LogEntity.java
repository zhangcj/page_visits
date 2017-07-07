package com.beecho.easyuse.LogModule;

/**
 * Created by Administrator on 2017/7/5.
 *
 * 日志
 */
public class LogEntity {

    public LogEntity(LogContent content) {
        this.content = content;
    }

    public LogEntity(LogType type, LogLevel level, LogContent content) {
        this.type = type;
        this.level = level;
        this.content = content;
    }

    public LogType getType() {
        return type;
    }

    public void setType(LogType type) {
        this.type = type;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogContent getContent() {
        return content;
    }

    public void setContent(LogContent content) {
        this.content = content;
    }

    private LogType type;
    private LogLevel level;
    private LogContent content;
}
