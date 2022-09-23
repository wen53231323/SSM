package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class 使用ResponseBody注解响应json数据 {

    @RequestMapping("/test")
    public String TestAjax(){
        // 此时会跳转到逻辑视图success所对应的页面
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testResponseBody")
    public String testResponseBody(){
        // 此时响应浏览器数据success
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testResponseBody_pojo")
    public User testResponseBody_pojo(){
        User user = new User(1, "小明", "123", 18, "男");
        return user;
    }

    @ResponseBody
    @RequestMapping("/testResponseBody_Map")
    public Map<String, Object> testResponseBody_Map(){
        User user1 = new User(1, "小明", "123", 18, "男");
        User user2 = new User(1, "小明", "123", 18, "男");
        User user3 = new User(1, "小明", "123", 18, "男");
        Map<String, Object> map = new HashMap<>();
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);
        return map;
    }

    @ResponseBody
    @RequestMapping("/testResponseBody_List")
    public List<User> testResponseBody_List(){
        User user1 = new User(1, "小明", "123", 18, "男");
        User user2 = new User(1, "小明", "123", 18, "男");
        User user3 = new User(1, "小明", "123", 18, "男");
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }

}
