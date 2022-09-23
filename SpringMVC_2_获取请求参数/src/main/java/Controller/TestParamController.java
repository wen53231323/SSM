package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {
    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
    // localhost:8080/
    @RequestMapping("/")
    public String index() {
        System.out.println("访问首页成功");
        //设置视图名称
        return "index";
    }

    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    @RequestMapping("/param/servletAPI")
    //将HttpServletRequest作为控制器方法的形参，就可以在控制器方法中使用request对象获取请求参数
    public String testParam(HttpServletRequest request) {
        // 根据名称获取参数值(单个值)
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username：" + username);
        System.out.println("password：" + password);
        return "success";
    }

    @RequestMapping("/param1")
    public String testParam1(String username, String password) {
        System.out.println("username：" + username);
        System.out.println("password：" + password);
        return "success";
    }

    @RequestMapping("/param2")
    public String testParam2(
            // @RequestParam()：将请求参数和控制器方法的形参绑定（创建映射关系）
            // value：设置与形参绑定的请求参数的名字
            // required：设置是否必须传输此请求参数，默认值为true
            // defaultValue：设置默认请求参数
            @RequestParam(value = "USERNAME", required = false, defaultValue = "wen") String username,
            @RequestParam(value = "PASSWORD", defaultValue = "123") String password
    ) {
        System.out.println("username：" + username);
        System.out.println("password：" + password);
        return "success";
    }

    @RequestMapping("/param3")
    public String testParam3(
            // 将请求头信息和控制器方法的形参绑定（属性用法同@RequestParam）
            @RequestHeader(value = "User-Agent",defaultValue = "defaultHeader") String referer,
            // 将cookie数据和控制器方法的形参绑定（属性用法同@RequestParam）
            @CookieValue(value = "JSESSIONID",defaultValue = "defaultCookie") String cookie
    ) {
        System.out.println("User-Agent：" + referer);
        System.out.println("cookie：" + cookie);
        return "success";
    }

    @RequestMapping("/param4")
    public String testPOJO(User user){
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "success";
    }

    @RequestMapping("/param5")
    public String testParam5(User user){
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "success";
    }


}
