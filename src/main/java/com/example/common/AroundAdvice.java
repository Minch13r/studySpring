package com.example.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 서비스의 성능체크에서 많이 사용됨
// 서비스의 전후를 전부 다 봄
// 트래픽 사용량, 시간 등 확인할 때 유용함.
public class AroundAdvice {
    // JoinPoint == CRUD
    // 커맨드객체처럼 CRUD 메서드 그 자체를 받아올 수 있음
    public void printLog(ProceedingJoinPoint pjp){ // 바인드 변수
        System.out.println("AROUND 공통 로그 시작");

        StopWatch sw = new StopWatch();
        sw.start();

        // 서비스 돌린 다음에~
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        sw.stop();

        System.out.println("AROUND 공통 로그 끝 >> " + sw.getTotalTimeMillis());
    }
}
