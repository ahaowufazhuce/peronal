package spring.ioc.container.overview;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.dependency.lookup.annotation.Super;

import java.util.Map;

/**
 * IocContainerOverviewDemo
 *
 * @author pengxing on 2020/10/24
 */
public class IocContainerOverviewDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int i = reader.loadBeanDefinitions("classpath:/META-INF/ioc-container-overview.xml");
        System.out.println("Bean加载的数量 = " + i);
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("lookupByAnnotation, result = " + beansWithAnnotation);
    }
}
