package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        // 1. 스프링 컨테이너
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        // 2. 객체 요청

        // samsung test
        SamsungTV samsungTV = (SamsungTV) factory.getBean("samsungTV");
        System.out.println("SamsungTV Test");
        samsungTV.powerOn();
        samsungTV.volumeUp();
        samsungTV.volumeDown();
        samsungTV.powerOff();

        // lg test
        LgTV lgTV = (LgTV) factory.getBean("lgTV");
        System.out.println("LgTV Test");
        lgTV.powerOn();
        lgTV.volumeUp();
        lgTV.volumeDown();
        lgTV.powerOff();

        // 닫기
        factory.close();
    }
}
