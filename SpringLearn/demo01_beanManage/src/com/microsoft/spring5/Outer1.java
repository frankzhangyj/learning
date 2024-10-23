package com.microsoft.spring5;

public class Outer1 {
    private String oName;

    private Inner1 in;

    public void setoName(String oName) {
        this.oName = oName;
    }

    public void setInner(Inner1 in) {
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
