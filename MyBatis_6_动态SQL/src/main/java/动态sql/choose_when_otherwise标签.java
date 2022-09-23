package 动态sql;

import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtil;

import java.util.List;

public class choose_when_otherwise标签 {
    @Test
    public void getEmpBychoose() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp emp = new Emp(null, "", 18, "");
        List<Emp> empBychoose_cwo = mapper.getEmpBychoose_cwo(emp);
        empBychoose_cwo.forEach(System.out::println);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
