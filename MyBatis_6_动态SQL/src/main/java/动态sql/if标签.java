package 动态sql;

import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Dept;
import pojo.Emp;
import utils.SqlSessionUtil;

import java.util.List;

public class if标签 {
    @Test
    public void getEmpByCondition(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp emp = new Emp(null, "", 18, "男");
        List<Emp> empByCondition_if = mapper.getEmpByCondition_if(emp);
        System.out.println(empByCondition_if);

        // 关闭sqlSession对象
        sqlSession.close();
    }

}
