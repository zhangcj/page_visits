package com.beecho.easyuse.ioc;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/12.
 *
 * IOC容器
 */
public interface Container {

    /**
     * 根据 Class 获取 Bean
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(Class<T> clazz);

    /**
     * 根据名称获取 Bean
     * @param name
     * @param <T>
     * @return
     */
    public <T> T getBeanByName(String name);

    /**
     * 注册一个 Bean 到容器中
     * @param bean
     * @return
     */
    public Object registerBean(Object bean);

    /**
     * 注册一个 Class 到容器中
     * @param clazz
     * @return
     */
    public Object registerBean(Class<?> clazz) throws IllegalAccessException, InstantiationException;

    /**
     * 注册一个带名称的 Bean 到容器中
     * @param name
     * @param bean
     * @return
     */
    public Object registerBean(String name,Object bean);

    /**
     * 删除一个 Bean
     * @param clazz
     */
    public void remove(Class<?> clazz);

    /**
     * 根据名称删除一个 Bean
     * @param name
     */
    public void removeByName(String name);

    /**
     * 返回所有 Bean 对象名称
     * @return
     */
    public Set<String> getBeanNames();

    /**
     * 初始化装配
     */
    public void initWired();
}
