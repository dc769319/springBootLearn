package com.charles.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局错误处理，ControllerAdvice定义统一的异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * ExceptionHandler用来定义函数针对的异常类型
     * @param req 请求对象
     * @param e   异常
     * @return ModelAndView对象
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("e", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("/global/" + DEFAULT_ERROR_VIEW);
        return mav;
    }
}
