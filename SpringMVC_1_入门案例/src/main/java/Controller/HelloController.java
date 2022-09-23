package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping注解标识类，设置映射请求的请求路径的初始信息
// @RequestMapping("/test")
public class HelloController {
    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
    // localhost:8080/springMVC/
    @RequestMapping("/")
    public String index() {
        System.out.println("访问首页成功");
        //设置视图名称
        return "index";
    }

    @RequestMapping("/hello")
    public String HelloWorld() {
        System.out.println("访问HelloWorld成功");
        return "hello";
    }

    @RequestMapping(
            // 当访问/hello1或/hello2时，都会被此方法处理
            value = {"/hello1", "/hello2"},
            // 当通过get或post请求，访问/hello1或/hello2时，都会被此方法处理
            method = {RequestMethod.GET, RequestMethod.POST},
            // 此时请求参数必须携带username，不能携带password，参数username必须为wen，参数gender不能为女
            params = {"username", "!password", "username=wen", "gender!=女"},
            // 此时请求头信息必须携带username，不能携带password，参数username必须为wen，参数gender不能为女
            headers = {"username", "!password", "username=wen", "gender!=女"}
    )
    public String hello() {
        return "hello";
    }


    // 前端请求路由：/testRest/1/wen
    // 控制台：id = 1 username = wen
    @RequestMapping("/testRest/{id}/{username}")
    public String TestRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        return "hello";
    }


}
