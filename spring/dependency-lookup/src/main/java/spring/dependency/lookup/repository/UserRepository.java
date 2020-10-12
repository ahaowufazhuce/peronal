package spring.dependency.lookup.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import spring.dependency.lookup.domain.User;

import java.util.List;
import java.util.StringJoiner;

/**
 * UserRepository
 *
 * @author pengxing on 2020/10/3
 */
public class UserRepository {
    /**
     * 內建非 Bean 对象（依赖）
     * 包括[user,superUser,factoryBean,userRepository]
     */
    private BeanFactory beanFactory;

    /**
     * 自定义bean
     */
    private List<User> users;

    private ObjectFactory<ApplicationContext> objectFactory;

    private ApplicationContext applicationContext;

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserRepository.class.getSimpleName() + "[", "]")
                .add("beanFactory=" + beanFactory)
                .add("objectFactory=" + objectFactory)
                .add("users=" + users)
                .toString();
    }
}
