package 基于注解的AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解，标识普通组件，保证这个切面类能够放入IOC容器
@Component
// @Order(数值)：通过value属性设置优先级，值越小，优先级越高，默认值为Integer的最大值
@Order(1)
public class ValidateAspect {
    // 调用其他切面中的可重用的切入点表达式
    @Before("基于注解的AOP.LogAspec.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect ——> 前置通知");
    }
}
