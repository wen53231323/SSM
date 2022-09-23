package Controller;

import Dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Employee;

import java.util.Collection;

@Controller
public class TestRESTful {
    // @Autowired注解：自动装配（数据访问层）
    @Autowired
    private EmployeeDao employeeDao;

    // 查询所有员工数据
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        // 获取所有信息
        Collection<Employee> employeeList = employeeDao.getAll();
        // 添加到request域
        model.addAttribute("employeeList", employeeList);
        // 转发到详情页
        return "all_employee";
    }

    // 执行删除
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    // 进入添加页
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd(){
        return "add_employee";
    }

    // 执行添加
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    // 进入修改页
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    // 执行修改
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
