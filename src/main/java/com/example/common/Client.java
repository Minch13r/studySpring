package com.example.common;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath:applicationContext.xml")
public class Client {
    public static void main(String[] args) {
        ApplicationContext factory = SpringApplication.run(Client.class, args);

        BoardService boardService = factory.getBean(BoardService.class);
        MemberService memberService = factory.getBean(MemberService.class);
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("==== 메인 화면 ====");
                System.out.println("1. 게시글 추가");
                System.out.println("2. 회원가입");
                System.out.println("3. 로그인");
                System.out.println("0. 종료");
                System.out.print("번호를 선택해주세요 >> ");
                int num;
                num = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                System.out.println("\n==================");

                try {
                    if (num < 0 || num > 4) {
                        System.out.println("잘못된 번호입니다. 1~4 사이의 번호를 입력해주세요. ❌");
                        continue; // 다시 메뉴 표시
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력해주세요. ❌");
                    sc.nextLine(); // 잘못 입력된 값 비우기
                    continue; // 다시 메뉴 표시
                }

                if (num == 0) {
                    System.out.println("프로그램을 종료합니다. 👋");
                    return;
                }
                else if (num == 1) {
                    System.out.println("게시글 추가 START");
                    System.out.print("제목 입력 >> ");
                    String title = sc.nextLine();
                    System.out.print("내용 입력 >> ");
                    String content = sc.nextLine();
                    System.out.print("작성자 입력 >> ");
                    String writer = sc.nextLine();

                    BoardVO vo = new BoardVO();
                    vo.setTitle(title);
                    vo.setContent(content);
                    vo.setWriter(writer);
                    boardService.insert(vo);

                    List<BoardVO> datas = boardService.getBoardList(null);
                    for (BoardVO data : datas) {
                        System.out.println(data);
                    }
                    System.out.println("게시글 추가 END");
                }
                else if (num == 2) {
                    System.out.println("회원가입 START");
                    System.out.print("아이디를 입력해주세요 >> ");
                    String id = sc.nextLine();
                    System.out.print("비밀번호를 입력해주세요 >> ");
                    String pw = sc.nextLine();
                    System.out.print("이름을 입력해주세요 >>");
                    String name = sc.nextLine();

                    MemberVO vo = new MemberVO();
                    vo.setMid(id);
                    vo.setMpw(pw);
                    vo.setName(name);

                    boolean result = memberService.insert(vo);
                    if (result) {
                        System.out.println("회원가입 성공! ✅");
                    } else {
                        System.out.println("회원가입 실패 ❌");
                    }

                    List<MemberVO> datas = memberService.getMemberList(null);
                    for (MemberVO data : datas) {
                        System.out.println(data);
                    }
                    System.out.println("회원가입 END");
                }
                else if (num == 3) {
                    System.out.print("아이디를 입력해주세요 >> ");
                    String id = sc.nextLine();
                    System.out.print("비밀번호를 입력해주세요 >> ");
                    String pw = sc.nextLine();

                    MemberVO vo = new MemberVO();
                    vo.setMid(id);
                    vo.setMpw(pw);

                    MemberVO result = memberService.getMember(vo);
                    if (result != null) {
                        System.out.println("로그인 성공! 🔓");
                    } else {
                        System.out.println("로그인 실패! 🔒");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
