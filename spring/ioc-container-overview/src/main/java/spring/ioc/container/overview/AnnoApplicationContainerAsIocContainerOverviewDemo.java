package spring.ioc.container.overview;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.dependency.lookup.domain.User;

import java.util.Map;

/**
 * AnnoApplicationContainerAsIocContainerOverviewDemo
 *
 * @author pengxing on 2020/10/24
 */
public class AnnoApplicationContainerAsIocContainerOverviewDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnoApplicationContainerAsIocContainerOverviewDemo.class);
        applicationContext.refresh();
        lookupByType(applicationContext);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setName("测试");
        return user;
    }

    private static void lookupByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> beansWithAnnotation = listableBeanFactory.getBeansOfType(User.class);
        System.out.println("lookupByType, result = " + beansWithAnnotation);
    }
}
