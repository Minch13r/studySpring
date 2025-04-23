package com.example.common;

// ProceedingJoinPoint: AroundAdvice에서만 사용하는 특별한 JoinPoint
// 대상 메소드를 직접 실행(proceed)할 수 있는 기능을 제공함
import org.aspectj.lang.ProceedingJoinPoint;
// StopWatch: 시간 측정을 위한 Spring 유틸리티 클래스
// 메소드 실행 시간을 정밀하게 측정할 수 있음
import org.springframework.util.StopWatch;

// AroundAdvice 클래스: AOP에서 가장 강력한 Advice 유형
// 서비스의 성능체크에서 많이 사용됨
// 서비스의 전후를 전부 다 봄 (메소드 실행 전, 실행 중, 실행 후, 예외 발생 시 모두 제어 가능)
// 트래픽 사용량, 시간 등 확인할 때 유용함.
public class AroundAdvice {
    // JoinPoint == CRUD 메소드
    // 커맨드객체처럼 CRUD 메소드 그 자체를 받아올 수 있음
    // ProceedingJoinPoint는 JoinPoint를 확장한 인터페이스로 proceed() 메소드를 추가로 제공
    public Object printLog(ProceedingJoinPoint pjp){ // 바인드 변수 - AOP 설정에서 연결된 대상 메소드 정보
        // Around Advice 시작 메시지 출력
        System.out.println("AROUND 공통 로그 시작");

        // StopWatch 객체 생성 - 메소드 실행 시간 측정용
        StopWatch sw = new StopWatch();
        // 시간 측정 시작
        sw.start();

        // 결과값을 저장할 변수 선언
        Object result = null;

        // 서비스 메소드 실행
        // proceed() 메소드는 실제 대상 메소드를 호출함
        // 이 호출을 생략하면 대상 메소드는 실행되지 않음
        try {
            // 대상 메소드 실행 및 결과 저장
            result = pjp.proceed();
        } catch (Throwable e) {
            // 예외 발생 시 스택 트레이스 출력
            // 여기서 예외를 처리하거나, 다른 예외로 변환하거나, 무시할 수 있음
            e.printStackTrace();
        }

        // 시간 측정 종료
        sw.stop();

        // Around Advice 종료 메시지와 함께 측정된 총 실행 시간(밀리초) 출력
        System.out.println("AROUND 공통 로그 끝 >> " + sw.getTotalTimeMillis() + "ms");

        // 대상 메소드의 반환값을 그대로 반환
        // 필요에 따라 반환값을 변경하거나 가공할 수도 있음
        return result;
    }
}
