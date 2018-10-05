package com.kingofus.webapi;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = {Exception.class})
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getLocalizedMessage());
        return "error";
    }


}
