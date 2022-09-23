package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

import java.util.List;

public interface EmpMapper {

    // 根据id查询员工信息（一级缓存测试）
    Emp getEmpById(@Param("empId") Integer empId);

}
