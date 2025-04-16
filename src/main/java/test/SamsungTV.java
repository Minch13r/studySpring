package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {
    @Autowired
    @Qualifier("samsungRemote")
    private Remote remote;

    public SamsungTV(){
        System.out.println("SamsungTV");
    }

    public SamsungTV(SamsungRemote remote){
        this.remote = remote;
        System.out.println("SamsungTV - DI");
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
