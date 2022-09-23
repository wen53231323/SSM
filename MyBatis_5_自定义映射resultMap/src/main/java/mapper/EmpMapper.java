package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

import java.util.List;

public interface EmpMapper {
    // 根据id查询员工信息（不含部门dept）
    Emp getEmpByEmpId_1(@Param("empId") Integer empId);

    // 根据id查询员工信息（不含部门dept）
    Emp getEmpByEmpId_2(@Param("empId") Integer empId);

    // 根据id查询员工信息，以及对应的部门信息（级联方式）
    Emp getEmpAndDeptByEmpId_1(@Param("empId") Integer empId);

    // 根据id查询员工信息，以及对应的部门信息（association方式）
    Emp getEmpAndDeptByEmpId_2(@Param("empId") Integer empId);

    // 根据id查询员工信息，以及对应的部门信息（分步查询方式）
    // 步骤一：根据id查询员工信息
    Emp getEmpAndDeptByStep_1(@Param("empId") Integer empId);

    // 根据部门id查询部门及部门中员工的信息（分步查询处理）
    // 步骤二：根据id查询部门的员工集合
    List<Dept> getDeptAdeptIdndEmpByStep_1(@Param("deptId") Integer deptId);

}
