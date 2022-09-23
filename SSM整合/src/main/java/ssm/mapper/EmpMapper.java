package ssm.mapper;

import ssm.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    // 获取所有用户
    List<Emp> getAll();
}
