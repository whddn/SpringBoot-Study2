package com.beaksoo.shop;

public class Information {
    private String name;
    private Integer age;

    public Information(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("현재 나이는 " + age + " 이름은 " + name +"입니다.");
    }

    public void 한살더하기() {
        age++;
    }

    public void 나이설정(Integer targetAge){
        if (targetAge < 100 && targetAge > 0) {
            this.age = targetAge;
        }
    }

    public Integer getAge() {
        return this.age;
    }
}

