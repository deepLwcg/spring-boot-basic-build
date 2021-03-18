package cn.yajienet.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 23:31
 */
@ControllerAdvice
public class DemoControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest request, Exception e, HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("error",e.getLocalizedMessage());
        return view;
    }
}
