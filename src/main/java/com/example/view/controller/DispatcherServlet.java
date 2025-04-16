package com.example.view.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;

import java.io.IOException;

// frontcontoller 역할
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public DispatcherServlet() {
        super();
    }

    public void init() {
        this.handlerMapping = new HandlerMapping();
        this.viewResolver = new ViewResolver();
        this.viewResolver.setPrefix("");
        this.viewResolver.setSuffix(".jsp"); // .jsp 를 자동으로 붙일수있게 설정
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getRequestURI();
        System.out.println("command 로그 ["+command+"]");
        command = command.replace("/demo", "");

        Controller ctrl = handlerMapping.getController(command);
        String viewName = ctrl.execute(request, response);

        if(viewName.contains(".do")) {
            // C 로 이동
        }
        else {
            // V 로 이동

            viewName = viewResolver.getViewName(viewName);
            // VR야, 접두어 접미어 붙여서 viewName을 완성해줘~~~
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }
}
