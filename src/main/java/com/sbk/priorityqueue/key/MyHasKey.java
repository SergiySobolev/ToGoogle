package com.sbk.priorityqueue.key;

public class MyHasKey implements HasKey<Integer> {

    private String data;

    private Integer key;

    public MyHasKey(Integer key, String data) {
        this.data = data;
        this.key = key;
    }

    @Override
    public Integer getKey() {
        return key;
    }
}
