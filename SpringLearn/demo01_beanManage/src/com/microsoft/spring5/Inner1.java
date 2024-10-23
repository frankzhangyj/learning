package com.microsoft.spring5;

public class Inner1 {
    private String iName;

    public void setiName(String iName) {
        this.iName = iName;
    }

    @Override
    public String toString() {
        return "Inner{" +
                "iName='" + iName + '\'' +
                '}';
    }
}
