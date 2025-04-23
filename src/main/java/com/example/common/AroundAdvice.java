package com.example.common;

public class AroundAdvice {
    // 서비스의 성능체크에서 많이 사용됨
    // 서비스의 전후를 전부 다 봄
    // 트래픽 사용량, 시간 등 확인할 때 유용함.
    public void printLog(){
        System.out.println("AROUND 공통 로그");
    }
}
