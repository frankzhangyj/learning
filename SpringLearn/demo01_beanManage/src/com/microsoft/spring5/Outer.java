package com.microsoft.spring5;

public class Outer {
    private String oName;
    private Inner inner;

    public void setoName(String oName) {
        this.oName = oName;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "Outer{" +
                "oName='" + oName + '\'' +
                ", inner=" + inner +
                '}';
    }
}
