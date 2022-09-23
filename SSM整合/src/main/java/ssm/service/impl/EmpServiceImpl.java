package ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.EmpMapper;
import ssm.pojo.Emp;
import ssm.service.EmpService;
import java.util.List;

// @Transactional：该类中的方法会被事务管理
@Transactional
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getAll() {
        // 返回所有数据
        return empMapper.getAll();
    }

    @Override
    public PageInfo<Emp> getEmpPage(Integer pageNum) {
        // 在查询功能之前开启分页（当前页码，每页5条数据）
        PageHelper.startPage(pageNum, 5);
        // 查询所有数据
        List<Emp> list = empMapper.getAll();
        // 查询功能之后，可以获得分页相关的所有数据
        PageInfo<Emp> page = new PageInfo<>(list, 5);
        return page;
    }
}
