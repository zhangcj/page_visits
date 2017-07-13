package com.beecho.easyuse.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/7/13.
 *
 * 需要自动注入的属性
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

    /**
     * 要注入的类型
     * @return
     */
    Class<?> value() default Class.class;

    /**
     * bean的名称
     * @return
     */
    String name() default "";
}
