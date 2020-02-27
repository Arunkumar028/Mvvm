package com.example.shimmerrecyclerview.other;

public class Serilalization {

    String name;
    String age;
    String address;

    public Serilalization(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setaddress(String address) {
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
}
