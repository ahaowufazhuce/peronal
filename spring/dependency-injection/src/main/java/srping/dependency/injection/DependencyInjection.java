package srping.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dependency.lookup.annotation.Super;
import spring.dependency.lookup.domain.User;
import spring.dependency.lookup.repository.UserRepository;

import java.util.ArrayList;
import java.util.Map;

/**
 * DependencyInjection
 *
 * @author pengxing on 2020/9/28
 */
public class DependencyInjection {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository bean = beanFactory.getBean(UserRepository.class);
        System.out.println(bean.getApplicationContext() == beanFactory);
        User user = new User();
    }
}
