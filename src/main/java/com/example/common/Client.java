package com.example.common;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath:applicationContext.xml")
public class Client {
    public static void main(String[] args) {
        ApplicationContext factory = SpringApplication.run(Client.class, args);

        BoardService service = factory.getBean(BoardService.class);

        Scanner sc = new Scanner(System.in);
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
        service.insert(vo);

        List<BoardVO> datas = service.getBoardList(null);
        for (BoardVO data : datas) {
            System.out.println(data);
        }

        sc.close();
    }
}
