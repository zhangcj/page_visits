package com.beecho.easyuse.ioc;

/**
 * Created by Administrator on 2017/7/13.
 */
public class Soldier {
    public Soldier() {
    }

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
        System.out.println("****name:" + this.name + "****");
        System.out.println("****outfit:" + this.outfit + "****");
    }
}
