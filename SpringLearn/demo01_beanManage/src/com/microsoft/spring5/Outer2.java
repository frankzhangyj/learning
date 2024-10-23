package com.microsoft.spring5;

public class Outer2 {
    private String oName;

    private Inner2 in;

    public Inner2 getInner() {
        return in;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public void setInner(Inner2 in) {
        this.in = in;
    }

    @Override
    public String toString() {
        return "Outer{" +
                "oName='" + oName + '\'' +
                ", inner=" + in +
                '}';
    }
}
