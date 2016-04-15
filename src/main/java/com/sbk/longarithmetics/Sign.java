package com.sbk.longarithmetics;

public enum Sign {
    PLUS,
    MINUS;

    public Sign revert(){
        if(this == PLUS) return MINUS;
        return PLUS;
    }
}
