package com.beaksoo.shop;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
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

