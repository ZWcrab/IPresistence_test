package com.custom.test;

import com.custom.dao.IUserDao;
import com.custom.io.Resources;
import com.custom.sqlSession.SqlSession;
import com.custom.sqlSession.SqlSessionFactory;
import com.custom.sqlSession.SqlSessionFactoryBuilder;
import com.custom.pojo.User;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws PropertyVetoException, DocumentException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {
        // 读取配置文件到内存
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建sqlSession工厂，并解析内存中的数据到容器中
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //打开sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        User zhangsan = sqlSession.queryOne("com.custom.dao.IUserDao.findByOne", "zhangsan");
//        System.out.println(zhangsan);


        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        // 新增
//        User user = new User();
//        user.setUserCode("111");
//        user.setUserName("王五");
//        userDao.createUser(user);

        // 修改
//        User user = new User();
//        user.setId(5);
//        user.setUserCode("222");
//        userDao.updateUser(user);

        // 删除
        User user = new User();
        user.setId(5);
        userDao.deleteById(user);


    }
}
