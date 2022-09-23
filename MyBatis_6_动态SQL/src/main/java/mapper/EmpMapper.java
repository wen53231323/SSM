package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

import java.util.List;

public interface EmpMapper {

    // 根据条件查询员工信息（if标签测试）
    List<Emp> getEmpByCondition_if(Emp emp);

    // 根据条件查询员工信息（where标签测试）
    List<Emp> getEmpByCondition_where(Emp emp);

    // 根据条件查询员工信息（trim标签测试）
    List<Emp> getEmpByCondition_trim(Emp emp);

    // 根据条件查询员工信息（choose、when、otherwise标签测试）
    List<Emp> getEmpBychoose_cwo(Emp emp);

    // 批量添加员工信息（foreach标签测试）
    void insertMoreEmp(@Param("emps")List<Emp> emps);

    // 批量删除员工信息（foreach标签测试）
    void deleteMoreEmpByArray(@Param("empIds") Integer[] empIds);

    // 查询所有员工（sql标签测试）
    List<Emp> selectAllEmp();

}
