package 逆向工程MyBatis3Simple简洁版.mapper;

import java.util.List;
import 逆向工程MyBatis3Simple简洁版.pojo.Emp;

public interface EmpMapper {
    // 根据主键删除数据
    int deleteByPrimaryKey(Integer empId);

    // 插入一条数据
    int insert(Emp record);

    // 根据主键查询信息
    Emp selectByPrimaryKey(Integer empId);

    // 查询表中所有数据
    List<Emp> selectAll();

    // 根据主键更新修改信息
    int updateByPrimaryKey(Emp record);
}