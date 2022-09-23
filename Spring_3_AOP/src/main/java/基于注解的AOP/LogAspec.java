package 基于注解的AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类，为计算器添加日志功能
 * */

// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解，标识标识普通组件，保证这个切面类能够放入IOC容器
@Component
public class LogAspec {
    /**
     （1）通知方法
     在切面中，需要通过指定的注解将方法标识为通知方法
     前置通知：使用@Before注解标识，在被代理的目标方法前执行
     返回通知：使用@AfterReturning注解标识，在被代理的目标方法成功结束后执行（寿终正寝）
     异常通知：使用@AfterThrowing注解标识，在被代理的目标方法异常结束后执行（死于非命）
     后置通知：使用@After注解标识，在被代理的目标方法最终结束后执行（盖棺定论）
     环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置
     **/
    /**
     * （2）切入点表达式：设置在标识通知的注解的value中
     * 1.例如：前置通知注解@Before("execution(public int 基于注解的AOP.CalculatorImpl.add(int ,int ))")中
     * 切入点表达式为：execution(public int 基于注解的AOP.CalculatorImpl.add(int ,int ))
     * 2.对于切入点表达式：execution(* 基于注解的AOP.*.*(..))
     * 第一个*表示：任意的访问修饰符和返回值类型
     * 第二个*表示：类中的任意方法
     * 点点..表示：任意的参数列表
     * 3.类的地方也可以使用*，表示包下所有的类
     **/

    // @Pointcut：声明可重用的切入点表达式
    @Pointcut("execution(* 基于注解的AOP.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    // @Before：前置通知，在目标对象方法执行之前执行
    // 精确写法：
    // @Before("execution(public int 基于注解的AOP.CalculatorImpl.add(int ,int ))")
    // 通用写法：
    @Before("execution(* 基于注解的AOP.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的方法名
        Signature methodName = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名：" + methodName.getName() + "，参数：" + Arrays.toString(args));
    }

    // @After：后置通知，在被代理的目标方法最终结束后执行（盖棺定论）
    // 使用可重用的切入点表达式
    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的方法名
        Signature methodName = joinPoint.getSignature();
        System.out.println("Logger-->后置通知，方法名：" + methodName.getName() + "，方法执行完毕");
    }

    // @AfterReturning：返回通知，在被代理的目标方法成功结束后执行（寿终正寝）
    // 在返回通知中，若要获取目标方法的返回值，只需要通过@AfterReturning注解的returning属性，
    // 就可以将某个通知方法的某个参数，指定为接收目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        // 获取连接点所对应方法的方法名
        Signature methodName = joinPoint.getSignature();
        System.out.println("Logger-->返回通知，方法名：" + methodName.getName() + "，结果：" + result);
    }

    // @AfterThrowing：异常通知，在被代理的目标方法异常结束后执行（死于非命）
    // 在异常通知中，若要获取目标对象方法的异常，只需要通过@AfterThrowing注解的throwing属性，
    //  // 就可以将某个通知方法的某个参数，指定为接收目标对象方法出现的异常的参数
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名：" + methodName + "，异常：" + ex);
    }

    // @Around：环绕通知，使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置
    @Around("pointCut()")
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
