package com.sbk.stringdistance;

import java.util.Objects;

import static com.sbk.stringdistance.LevenshteinDistance.findDistance;

public class Trace implements Cloneable{

    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    private long distance = 0;

    public Trace(){

    }

    public Trace(StringBuilder sb1, StringBuilder sb2) {
        this.sb1 = new StringBuilder(sb1);
        this.sb2 = new StringBuilder(sb2);
        distance = findDistance(sb1.toString(), sb2.toString());
    }

    public Trace(String sb1, String sb2) {
        this.sb1 = new StringBuilder(sb1);
        this.sb2 = new StringBuilder(sb2);
        distance = findDistance(sb1.toString(), sb2.toString());
    }

    public void append(char first, char second){
        sb1.append(first);
        sb2.append(second);
        distance = findDistance(sb1.toString(), sb2.toString());
    }

    public String getFirst(){
        return sb1.toString();
    }

    public String getSecond(){
        return sb2.toString();
    }

    public Trace clone(){
        return  new Trace(this.sb1, this.sb2);
    }

    public String toString(){
        return sb1.reverse().toString() + "\n" + sb2.reverse().toString()
                +"\n" + "Distance:" + distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trace trace = (Trace) o;
        return Objects.equals(sb1.toString(), trace.sb1.toString()) &&
                Objects.equals(sb2.toString(), trace.sb2.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sb1.toString(), sb2.toString());
    }
}
