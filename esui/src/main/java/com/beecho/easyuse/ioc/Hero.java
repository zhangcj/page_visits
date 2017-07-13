package com.beecho.easyuse.ioc;

import com.beecho.easyuse.ioc.annotation.Inject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/7/13.
 */
public class Hero {

    public Hero() {
    }

    @Inject(value = Soldier.class)
    private Soldier soldier;

    private String name;
    private String outfit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutfit() {
        return outfit;
    }

    public void setOutfit(String outfit) {
        this.outfit = outfit;
    }

    public void work() {
        System.out.println("----name:" + this.name + "----");

        soldier.setName("我是战士");
        soldier.setOutfit("我用手雷");
        soldier.work();

        System.out.println("----outfit:" + this.outfit + "----");
    }
}
