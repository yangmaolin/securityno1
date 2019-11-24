package com.lin.linsecurityno1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.OK)

    public ModelAndView processException(RuntimeException exception) {

        System.out.println("自定义");

        ModelAndView m = new ModelAndView();

        m.addObject("roncooException", exception.getMessage());

        m.setViewName("404");

        return m;

    }

}
