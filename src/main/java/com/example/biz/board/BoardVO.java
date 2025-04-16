package com.example.biz.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
    private int bid;
    private String title;
    private String content;
    private String writer;
    private int cnt;
}
