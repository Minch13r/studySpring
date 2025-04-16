package com.example.view.controller;

import com.example.view.member.LoginController;

import java.util.HashMap;
import java.util.Map;

// ActionFactory 역할
public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        this.mappings = new HashMap<String, Controller>();

        this.mappings.put("/login.do", new LoginController());
    }

    public Controller getController(String command) {
        return this.mappings.get(command);
    }
}
