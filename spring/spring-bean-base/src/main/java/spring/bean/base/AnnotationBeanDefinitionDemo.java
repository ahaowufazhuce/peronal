package spring.bean.base;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import spring.dependency.lookup.domain.User;

/**
 * 注解bean定义，三种方式，不会重复注册bean
 * 1.@Import这个注解也可以定义bean
 * 2.@Bean 注册配置类，代替xml文件
 * 3.@Component 这个注解，定义这个类为spring bean组件
 *
 * @author pengxing on 2020/10/25
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // @Bean 注册配置类，代替xml文件
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        registerUserBeanDefinition(applicationContext, "mercyUser");
        registerUserBeanDefinition(applicationContext);

        // 启动
        applicationContext.refresh();
        // 使用
        System.out.println("Config = " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User = " + applicationContext.getBeansOfType(User.class));
        // 关闭
        applicationContext.close();
    }

    /**
     * 指定名称方式 命名方式
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "张三");
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    /**
     * 非命名方式
     *
     * @param registry
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    /**
     * @Component 这个注解，定义这个类为spring bean组件
     */
    @Component
    public static class Config {
        @Bean(name = {"user", "testUser"})
        public User user() {
            User user = new User();
            user.setName("测试");
            return user;
        }
    }
}