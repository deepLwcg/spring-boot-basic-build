package cn.yajienet.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 23:32
 */
//@RestControllerAdvice // ControllerAdvice + ResponseBody
public class DemoApiControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Object exception(HttpServletRequest request, Exception e, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("error",e.getLocalizedMessage());
        return map;
    }

}
