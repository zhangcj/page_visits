package com.beecho.easyuse.ioc;

import com.beecho.easyuse.ioc.annotation.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.misc.ReflectUtil;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/7/12.
 *
 * 容器简答实现
 */
public class SampleContainer implements Container {

    /**
     * 保存所有 Bean 对象
     */
    private Map<String,Object> beans;
    /**
     * 存储 Bean 和 Name 的关系
     */
    private Map<String,String> beanKeys;

    public SampleContainer(){
        this.beans = new ConcurrentHashMap<String,Object>();
        this.beanKeys = new ConcurrentHashMap<String,String>();
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        String name = clazz.getName();
        if (name == null || name.equals(""))
            return null;
        Object object = beans.get(name);
        if (null != object)
            return (T) object;
        return null;
    }

    @Override
    public <T> T getBeanByName(String name) {
        String className = beanKeys.get(name);
        if (null == className || className.equals(""))
            return null;
        Object object = beans.get(className);
        if (null != object)
            return (T) object;
        return null;
    }

    @Override
    public Object registerBean(Object bean) {
        String name = bean.getClass().getName();
        beanKeys.put(name,name);
        beans.put(name,bean);
        return bean;
    }

    @Override
    public Object registerBean(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        String name = clazz.getName();
        beanKeys.put(name,name);
        Object bean = ReflectUtil.newInstance(clazz);
        beans.put(name,bean);
        return bean;
    }

    @Override
    public Object registerBean(String name, Object bean) {
        String className = bean.getClass().getName();
        beanKeys.put(name,className);
        beans.put(className,bean);
        return bean;
    }

    @Override
    public void remove(Class<?> clazz) {
        String className = clazz.getName();
        if (null != className && !className.equals("")) {
            beanKeys.remove(className);
            beans.remove(className);
        }
    }

    @Override
    public void removeByName(String name) {
        String className = beanKeys.get(name);
        if (null != className && !className.equals("")) {
            beanKeys.remove(name);
            beans.remove(className);
        }
    }

    @Override
    public Set<String> getBeanNames() {
        return beanKeys.keySet();
    }

    @Override
    public void initWired() {
        Iterator<Map.Entry<String, Object>> it = beans.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            Object object = entry.getValue();
            injection(object);
        }
    }

    public void injection(Object object) {
        try {
            // 获取所有字段
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                // 存在需要注入的字段
                if (field.isAnnotationPresent(Inject.class)) {
                    // 要注入的字段
                    Class<?> injectdField = Class.forName(field.getType().getName(), false, Thread.currentThread().getContextClassLoader());
                    Object existObject = this.getBeanByName(injectdField.getName());
                    if (null == existObject) {
                        try {
                            boolean accessible = field.isAccessible();
                            if (!accessible)
                                field.setAccessible(true);
                            field.set(object, injectdField.newInstance()); // 赋值给注入字段
                            field.setAccessible(accessible);
                            this.registerBean(injectdField);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

//                Inject inject = field.getAnnotation(Inject.class);
//                if (null != inject) {
//                    Object injectField = null; // 要注入的属性
//                    String name = inject.name();
//                    if (!name.equals("")) {
//                        String className = beanKeys.get(name);
//                        if (null != className && !className.equals("")) {
//                            injectField = beans.get(className);
//                        }
//                        if (null == injectField) {
//                            throw new RuntimeException("Unable to load " + name);
//                        }
//                    } else {
//                        if (inject.value() == Class.class) {
//                            injectField = recursiveAssembly(field.getType());
//                        } else {
//                            injectField = this.getBean(inject.value());
//                            if (null == injectField) {
//                                injectField = recursiveAssembly(inject.value());
//                            }
//                        }
//                    }
//
//                    if (null == injectField) {
//                        throw new RuntimeException("Unable to load " + field.getType().getCanonicalName());
//                    }
//
//                    boolean accessible = field.isAccessible();
//                    if (!accessible)
//                        field.setAccessible(true);
//                    field.set(object, injectField); // 赋值给注入字段
//                    field.setAccessible(accessible);
//                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Object recursiveAssembly(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        if (null != clazz) {
            return this.registerBean(clazz);
        }
        return null;
    }
}
