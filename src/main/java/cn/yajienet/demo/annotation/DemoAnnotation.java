package cn.yajienet.demo.annotation;

import java.lang.annotation.*;

// 标注这个类它可以标注的位置
@Target({ElementType.METHOD,ElementType.TYPE})
// 标注这个类它可以标注的位置
@Retention(RetentionPolicy.RUNTIME)
// 是否生成注解文档
@Documented
public @interface DemoAnnotation {

    String name() default "";

    String value() default "";

}
