package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

public interface DeptMapper {
    // 根据id查询员工信息，以及对应的部门信息（分步查询方式）
    // 步骤二：根据id查询部门信息
    Dept getEmpAndDeptByStep_2(@Param("deptId") Integer deptId);

    // 根据部门id查询部门及部门中员工的信息（collection处理）
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    // 根据部门id查询部门及部门中员工的信息（分步查询处理）
    // 步骤一：根据部门查员工
    Dept getDeptAndEmpByStep_1(@Param("deptId") Integer deptId);





}
