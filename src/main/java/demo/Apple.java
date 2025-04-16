package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// new 역할
@Component("apple") // <bean id="apple"></bean> 태그 역할을 함
public class Apple {
    // 멤버변수면 의존관계 -> DI(이러면 대충 80% 맞음 ㅋㅋ)
    @Autowired // 생성자 주입, setter 주입과 같은 DI
    private Kiwi kiwi; // 의존 관계 -> 의존성 주입(==DI)
    private int cnt;

    public Apple(){
        this.cnt = 0;
        System.out.println("사과 객체 생성 완료");
    }
/*
    public Apple(Kiwi kiwi){
        this.kiwi = kiwi;
        System.out.println("사과 객체 생성 완료2");
    }
*/
    public void check(){
        this.cnt++;
        System.out.println("현재 cnt ["+this.cnt+"]");
        ///kiwi.test();
    }

    public void initMethod(){
        System.out.println("생성자 역할");
        System.out.println("연결, 메모리 할당 역할");
    }

    public void destroyMethod(){
        System.out.println("연결 해제 역할");
    }
}
