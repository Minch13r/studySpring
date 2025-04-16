package test;

import org.springframework.stereotype.Component;

// 리모컨 종류인것만 보기 때문에 자료형 필요 X component랑 autowired만 쓸 때
@Component("samsungRemote")
public class SamsungRemote implements Remote {

    public SamsungRemote() {
        System.out.println("SamsungRemote create");
    }
    @Override
    public void powerOn(){
        System.out.println("Samsung Powered On");
    }
    @Override
    public void volumeUp(){
        System.out.println("Samsung Volumed Up");
    }
    @Override
    public void volumeDown(){
        System.out.println("Samsung Volumed Down");
    }
    @Override
    public void powerOff(){
        System.out.println("Samsung Powered Off");
    }
}
