package com.cts.links.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.SystemPropertyUtils;

@SpringBootApplication
@ComponentScan("com.cts.links")
public class LinkApp {
	public static void main(String ar[]){
	SpringApplication.run(LinkApp.class,ar);
	System.out.println("Spring boot Started");
	
	
	}
	

}
