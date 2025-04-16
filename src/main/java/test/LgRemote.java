package test;

import org.springframework.stereotype.Component;


// 리모컨 종류인것만 보기 때문에 자료형 필요 X component랑 autowired만 쓸 때
@Component("lgRemote")
public class LgRemote implements Remote {
    private LgTV lgTV;

    public LgRemote() {
        System.out.println("LgRemote create");
    }
    @Override
    public void powerOff(){
        System.out.println("LG Powered Off");
    }
    @Override
    public void volumeUp(){
        System.out.println("LG Volumed Up");
    }
    @Override
    public void volumeDown(){
        System.out.println("LG Volumed Down");
    }
    @Override
    public void powerOn(){
        System.out.println("LG Powered On");
    }
}
