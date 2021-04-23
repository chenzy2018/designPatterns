package com.designPatterns.a01singleton;

/**
 * 枚举可以通过构造函数给枚举项加参数，但构造函数不能是public的，因此不能被反序列化
 */
public enum TestEnum {

    dfs("dsf"),
    sdfs("sdfs"),
    sdews("sdews"),
    dsfs("dsfs");

    private String descript;

    private TestEnum(String descript){this.descript = descript;}
}
