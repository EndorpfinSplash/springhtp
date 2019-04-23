package com.htp;

import com.htp.config.core.AppConfig1;
import com.htp.domain.User;
import com.htp.repository.UserDao;
import com.htp.repository.UserDaoUtil;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//        Car myCar = (Car) context.getBean("myCar");
//        System.out.println("Simple " + myCar.getModel());
//
//        Car myCar2 = (Car) context.getBean("myCar2");
//
//        System.out.println("With engine " + myCar2.getEngine().getVolume());
//
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.htp");
//        Car myCar = (Car) context.getBean("supercar");
//        System.out.println("Simple " + myCar.getModel());
//        System.out.println("Engine inside car " + myCar.getEngine().getVolume());
//
//        Engine carEngine = (Engine) context.getBean("carEngine");
//        System.out.println("Engine info :" + carEngine.getVolume());

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        UserDao userDao = (UserDao) context.getBean("userDaoImpl");
        UserDaoUtil userDaoUtil = (UserDaoUtil) context.getBean("userDaoUtil");

        userDaoUtil.testOperations();

        for (User user : userDao.findAll()) {
            System.out.println(user.toString());
        }

    }
}
