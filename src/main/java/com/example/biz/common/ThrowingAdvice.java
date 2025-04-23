package com.example.biz.common;

// AspectJ의 JoinPoint 클래스 임포트 - Advice가 적용되는 지점의 정보를 담음
import org.aspectj.lang.JoinPoint;

// ThrowingAdvice 클래스: AfterThrowing Advice를 구현한 클래스
// 메소드 실행 중 예외가 발생했을 때만 동작하는 Advice
// 예외 처리, 로깅, 복구 전략 등을 구현할 수 있음
public class ThrowingAdvice {

    // printLog 메소드: AfterThrowing Advice의 로직이 구현된 메소드
    // JoinPoint: 대상 메소드의 정보를 담고 있음
    // Exception exceptObj: 대상 메소드에서 발생한 예외 객체(XML 설정의 throwing 속성과 매핑됨)
    public void printLog(JoinPoint jp, Exception exceptObj) {

        // AfterThrowing Advice 시작 메시지 출력
        System.out.println("THROWING 공통 로그");

        // 발생한 예외의 타입에 따라 다른 처리를 수행
        // instanceof 연산자로 예외 객체의 타입을 확인

        // IllegalArgumentException이 발생한 경우
        // 주로 메소드 인자가 유효하지 않을 때 발생하는 예외
        if(exceptObj instanceof IllegalArgumentException){
            // 생성 관련 예외 메시지 출력
            // 예: 객체 생성 시 필수 파라미터가 누락되었거나 유효하지 않은 경우
            System.out.println("create exception");
        }

        // 그 외 다른 타입의 예외가 발생한 경우
        else {
            // 처리 방법을 모르는 예외 타입인 경우 메시지 출력
            System.out.println("don't find exception");
        }
    }
}
