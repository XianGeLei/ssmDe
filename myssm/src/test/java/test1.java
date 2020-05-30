/*

import com.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test1 {

    @Test
    public void test11(){
        InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sessionFactory.openSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        List<User> users=userDao.findAll();
        System.out.println("ddd");
        for (User user:users){
            System.out.println(user);
        }

    }


    @Test
    public void test12(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=applicationContext.getBean(UserDao.class);
        List<User> users=userDao.findAll();
        System.out.println("ddd");
        for (User user:users){
            System.out.println(user);
        }

    }

    @Autowired
    UserService userService;
    @Test
    public void test13(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(userService);
        List<User> users=userService.findAll();
        System.out.println("ddd");
        for (User user:users){
            System.out.println(user);
        }

    }

}
*/
