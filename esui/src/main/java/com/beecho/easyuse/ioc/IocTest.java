package com.beecho.easyuse.ioc;

/**
 * Created by Administrator on 2017/7/13.
 */
public class IocTest {
    private static Container container = new SampleContainer();

    public static void baseTest() throws InstantiationException, IllegalAccessException {
        container.registerBean(Hero.class);
//        container.registerBean("face",new Hero());

        container.initWired();

        Hero hero = container.getBean(Hero.class);
//        Hero hero = container.getBeanByName("face");

        hero.setName("我是英雄");
        hero.setOutfit("我用手枪");
        hero.work();
    }
}
