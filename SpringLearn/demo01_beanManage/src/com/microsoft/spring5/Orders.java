package com.microsoft.spring5;

public class Orders {
    private String oname;
    private String address;
    private String age;
    private String bookname;

    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oname='" + oname + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", bookname='" + bookname + '\'' +
                '}';
    }
}
