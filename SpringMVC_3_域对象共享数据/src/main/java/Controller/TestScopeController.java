package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {
    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
    // localhost:8080/
//    @RequestMapping("/")
//    public String index() {
//        System.out.println("访问首页成功");
//        //设置视图名称
//        return "index";
//    }

    // 使用ServletAPI向request域对象共享数据
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, User user) {
        request.setAttribute("username", user.getUsername());
        request.setAttribute("password", user.getPassword());
        return "success";
    }

    // 使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(User user) {
        // ModelAndView有Model和View的功能
        // Model主要用于向请求域共享数据
        // View主要用于设置视图，实现页面跳转
        ModelAndView mav = new ModelAndView();

        // 向请求域共享数据
        mav.addObject("username", user.getUsername());
        mav.addObject("password", user.getPassword());

        // 设置视图，实现页面跳转
        mav.setViewName("success");

        // 使用时，控制方法必须将ModelAndView作为方法的返回值
        return mav;
    }

    // 使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model, User user) {
        // 向请求域共享数据
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        return "success";
    }

    // 使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap, User user) {
        modelMap.addAttribute("username", user.getUsername());
        modelMap.addAttribute("password", user.getPassword());
        return "success";
    }

    // 使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(User user,Map<String, Object> map) {
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        return "success";
    }

    // 使用ServletAPI向session域对象共享数据
    @RequestMapping("/testSession")
    public String testSession(User user,HttpSession session){
        session.setAttribute("username", user.getUsername());
        session.setAttribute("password", user.getPassword());
        return "success";
    }

    // 使用ServletAPI向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(User user,HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("username", user.getUsername());
        application.setAttribute("password", user.getPassword());
        return "success";
    }

}
