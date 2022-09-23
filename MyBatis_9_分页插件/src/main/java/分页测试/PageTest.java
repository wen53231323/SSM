package 分页测试;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;
import 逆向工程MyBatis3尊享版.mapper.EmpMapper;
import 逆向工程MyBatis3尊享版.pojo.Emp;

import java.util.List;

public class PageTest {
    @Test
    public void Test() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 在查询功能之前开启分页（当前页2，每页5条数据）
        Page<Object> objects = PageHelper.startPage(2, 5);
        System.out.println("---------->" + objects);

        // 查询所有数据
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);

        // 查询功能之后，可以获得分页相关的所有数据
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
        System.out.println(empPageInfo);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
