package com.beaksoo.shop;

public class Example {

    public static void main(String[] args) {
        Information student = new Information("이종우", 17);
        System.out.println("현재 나이 = " + student.getAge());
        student.한살더하기();
        System.out.println("현재 나이 = " + student.getAge());
        student.나이설정(12);
        System.out.println("현재 나이 = " + student.getAge());
    }
}
