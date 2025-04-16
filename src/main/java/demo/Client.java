package demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
    public static void main(String[] args) {

        // 1. 스프링 컨테이너를 구동
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        // 2. 스프링 컨테이너야, 객체 좀 줄래? 객체 요청 == Lookup
        Apple apple1 = (Apple) factory.getBean("apple");
        apple1.check();
        Banana banana = (Banana) factory.getBean("banana");
        banana.check();
        // lookup 횟수와 new 횟수는 다를 수 있다.
        // 스프링 컨테이너는 "싱글톤 패턴"을 유지하는 방향으로 객체를 관리한다!!
        // 싱글톤 패턴이란 메모리에 동일한 같은 자료형을 1개로 유지하는 디자인 패턴을 의미

        // 3. 스프링 컨테이너 종료
        factory.close();
    }
}
