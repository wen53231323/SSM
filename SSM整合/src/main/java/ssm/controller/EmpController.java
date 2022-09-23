package ssm.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssm.pojo.Emp;
import ssm.service.EmpService;
import java.util.List;

@Controller
public class EmpController {
    // 业务层对象
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private EmpService empService;

    // 查询所有员工数据
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        // 获取所有员工信息
        List<Emp> empList = empService.getAll();
        // 添加到request域
        model.addAttribute("empList", empList);
        // 转发到详情页
        return "emp_all";
    }

    // 分页查询所有员工数据
    @RequestMapping(value = "/emp/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(Model model, @PathVariable("pageNum") Integer pageNum){
        // 传入当前页码，返回分页对象
        PageInfo<Emp> page = empService.getEmpPage(pageNum);
        // 添加到request域
        model.addAttribute("page", page);
        // 转发到详情页
        return "emp_all_page";
    }

}
