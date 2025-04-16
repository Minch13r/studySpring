package test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Getter // getter 만들기
@Setter // setter 만들기, setter 주입한다고 해서 생성
@Component("lg")
public class LgTV implements TV {
    @Autowired
    @Qualifier("lgRemote")
    private Remote remote;

    public LgTV(){
        System.out.println("LgTV");
    }

    public LgTV(LgRemote remote){
        this.remote = getRemote();
        System.out.println("LgTV create");
    }

    @Override
    public void powerOn(){
        this.remote.powerOn();
    }
    @Override
    public void powerOff(){
        this.remote.powerOff();
    }
    @Override
    public void volumeUp(){
        this.remote.volumeUp();
    }
    @Override
    public void volumeDown(){
        this.remote.volumeDown();
    }
}