package spring.bean.base;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dependency.lookup.domain.User;

/**
 * BeanAliasDemo
 *
 * @author pengxing on 2020/10/25
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definitions-context.xml");

        User testUser1 = (User) beanFactory.getBean("testUser");
        User testUser2 = (User) beanFactory.getBean("user");

        System.out.println(testUser1);
        System.out.println(testUser2);
        // 别名获取等于原名获取
        System.out.println(testUser1 == testUser2);
    }
}
