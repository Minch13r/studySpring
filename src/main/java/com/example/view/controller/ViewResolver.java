package com.example.view.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViewResolver{
    public String prefix;
    public String suffix;
    public String getViewName(String viewName) {
        return this.prefix + viewName + this.suffix;
    }
}
