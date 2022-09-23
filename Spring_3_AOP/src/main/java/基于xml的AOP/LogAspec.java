package 基于xml的AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Component注解，标识标识普通组件，保证这个切面类能够放入IOC容器
@Component
public class LogAspec {

    // @Pointcut：声明可重用的切入点表达式
    @Pointcut("execution(* 基于xml的AOP.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    public void beforeMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的方法名
        Signature methodName = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名：" + methodName.getName() + "，参数：" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的方法名
        Signature methodName = joinPoint.getSignature();
        System.out.println("Logger-->后置通知，方法名：" + methodName.getName() + "，方法执行完毕");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        // 获取连接点所对应方法的方法名
        Signature methodName = joinPoint.getSignature();
        System.out.println("Logger-->返回通知，方法名：" + methodName.getName() + "，结果：" + result);
    }

    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名：" + methodName + "，异常：" + ex);
    }


    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        // 获取连接点所对应方法的方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取连接点所对应方法的参数
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前（前置通知）");
            //目标对象（连接点）方法的执行（目标方法的返回值一定要返回给外界调用者）
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后（返回通知）");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时（异常通知）");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕（后置通知）");
        }
        return result;
    }
}
