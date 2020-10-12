package spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dependency.lookup.annotation.Super;
import spring.dependency.lookup.domain.User;

import java.util.Map;

/**
 * DependencyLookUp
 *
 * @author pengxing on 2020/9/28
 */
public class DependencyLookUp {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        lookupByAnnotation(beanFactory);
        lookupByType(beanFactory);
        lookupById(beanFactory);
        lookupLazy(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("lookupByAnnotation, result = " + beansWithAnnotation);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("lookupByType, result = " + user);
    }

    private static void lookupById(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("lookupById, result = " + user);
    }

    private static void lookupLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("factoryBean");
        System.out.println("lookupLazy, result = " + objectFactory.getObject());
    }
}
