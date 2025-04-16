package com.example.view.controller;

import com.example.view.member.DetailController;
import com.example.view.member.InsertController;
import com.example.view.member.LoginController;

import java.util.HashMap;
import java.util.Map;

// ActionFactory 역할
public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        this.mappings = new HashMap<String, Controller>();

        this.mappings.put("/login.do", new LoginController());
        this.mappings.put("/insert.do", new InsertController());
        this.mappings.put("/detail.do", new DetailController())
    }

    public Controller getController(String command) {
        return this.mappings.get(command);
    }
}
