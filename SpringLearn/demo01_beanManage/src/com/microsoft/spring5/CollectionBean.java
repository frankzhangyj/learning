package com.microsoft.spring5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {
    private String[] array;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private List<User> userList;
    private List<User> userList2;

    public void setUserList2(List<User> userList2) {
        this.userList2 = userList2;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", userList=" + userList +
                ", userList2=" + userList2 +
                '}';
    }
}
