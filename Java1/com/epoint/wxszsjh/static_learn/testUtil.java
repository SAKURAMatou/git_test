package com.epoint.wxszsjh.static_learn;

public class testUtil {
    public static String STARIC_1 = "静态变量测试";


    public static String STATIC_Enthod() {
        return "静态方法";
    }

    public String FStaric1() {
        return "非静态方法";
    }

    static {
        System.out.println("静态代码块");
    }


    static class SingletonHolder {
        private testUtil instance;

    }


}



