package com.beaksoo.shop;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@ToString
@Getter
@Setter
public class Age {

    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}

   public void age(){
    this.age++;
   }

   var object = new Age();
    object.age();
    object.
