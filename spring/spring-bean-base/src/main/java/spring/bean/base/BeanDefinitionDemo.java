package spring.bean.base;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import spring.dependency.lookup.domain.User;

/**
 * BeanDefinitionDemo
 *
 * @author pengxing on 2020/10/25
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        // 通过beanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置属性
        beanDefinitionBuilder.addPropertyValue("name", "测试");
        beanDefinitionBuilder.addPropertyValue("age", 34);
        // 获取实例，并非终态，可以修改
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 直接构建

    }
}
