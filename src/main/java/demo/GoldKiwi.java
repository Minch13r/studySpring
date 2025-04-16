package demo;

import org.springframework.stereotype.Component;

@Component("goldkiwi")
public class GoldKiwi extends Kiwi{
    @Override
    public void test(){
        System.out.println("Gold Kiwi");
    }
}
