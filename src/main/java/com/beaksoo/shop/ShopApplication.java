package com.beaksoo.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);

		var test = new Friend("park");
		System.out.println(test.name);
	}

}

class Friend{
	String name = "kim";
	int age = 20;
	Friend(String a){
		this.name = a;
	}
}