package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("banana")
public class Banana {
    @Autowired
    private Kiwi kiwi;
    public Banana() {
        System.out.println("바나나 객체생성완료");
    }

    public void check(){
        kiwi.test();
    }
}
