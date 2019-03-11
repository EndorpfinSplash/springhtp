package com.htp;

import com.htp.domain.Car;
import com.htp.domain.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//        Car myCar = (Car) context.getBean("myCar");
//        System.out.println("Simple " + myCar.getModel());
//
//        Car myCar2 = (Car) context.getBean("myCar2");
//
//        System.out.println("With engine " + myCar2.getEngine().getVolume());

        ApplicationContext context = new AnnotationConfigApplicationContext("com.htp");
        Car myCar = (Car) context.getBean("supercar");
        System.out.println("Simple " + myCar.getModel());
        System.out.println("Engine inside car " + myCar.getEngine().getVolume());

        Engine carEngine = (Engine) context.getBean("carEngine");
        System.out.println("Engine info :" + carEngine.getVolume());
    }
}
