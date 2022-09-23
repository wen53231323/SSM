package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.Emp;

import java.util.List;

public interface EmpService {
    // 返回所有数据
    List<Emp> getAll();

    // 返回分页后的所有数据
    PageInfo<Emp> getEmpPage(Integer pageNum);
}
