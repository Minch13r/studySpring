package com.example.biz.common;

// AspectJ 라이브러리에서 제공하는 JoinPoint 클래스를 가져옴
// JoinPoint는 Advice가 적용되는 지점(메소드)의 정보를 담고 있음
import org.aspectj.lang.JoinPoint;

// LogAdvice 클래스: AOP에서 사용할 Before Advice 역할을 하는 클래스
// 메소드 실행 전에 로깅 작업을 수행함
public class LogAdvice {

    // printLog 메소드: 실제 Advice 로직이 구현된 메소드
    // JoinPoint 파라미터를 통해 대상 메소드의 정보를 받아옴
    // XML 설정에서 <aop:before method="printLog" ...>로 지정된 메소드
    public void printLog(JoinPoint jp){
        // 기본 로그 메시지 출력 - 메소드 실행 전에 출력됨
        System.out.println("BEFORE 공통 로그");

        // 대상 메소드의 이름 가져오기
        // getSignature()는 메소드의 시그니처(반환타입, 이름, 매개변수) 정보를 반환
        // getName()은 그 중에서 메소드 이름만 추출
        String methodName = jp.getSignature().getName();
        System.out.println("methodName = " + methodName);

        // 대상 메소드로 전달된 인자(파라미터) 목록 가져오기
        // getArgs()는 Object 배열 형태로 메소드의 모든 인자를 반환
        Object[] args = jp.getArgs();

        // 메소드에 전달된 인자의 개수 출력
        System.out.println("args = " + args.length);

        // 각 인자를 순회하면서 출력
        // 이를 통해 메소드에 어떤 값들이 전달되었는지 확인 가능
        for(Object arg : args){
            System.out.println(arg);
        }
    }
}
