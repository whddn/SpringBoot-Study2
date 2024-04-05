package com.beaksoo.shop;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public Integer price;
}

@Entity
class Notice{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String 글제목;
    public Date 날짜;
}

