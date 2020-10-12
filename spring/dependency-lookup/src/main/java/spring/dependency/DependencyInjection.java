package spring.dependency;

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
 * DependencyLookUp
 *
 * @author pengxing on 2020/9/28
 */
public class DependencyInjection {

    /**
     *
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository bean = beanFactory.getBean(UserRepository.class);
        System.out.println(bean.getApplicationContext() == beanFactory);
    }
     * @param args
     */

    public static long[] rewards = {1, 2, 5, 10};  // 四种面额的纸币

    /**
     * @Description:  使用函数的递归（嵌套）调用，找出所有可能的奖赏组合
     * @param totalReward-奖赏总金额，result-保存当前的解
     * @return void
     */

    public static void get(long totalReward, ArrayList<Long> result) {
        // 当totalReward = 0时，证明它是满足条件的解，结束嵌套调用，输出解
        if (totalReward == 0) {
            System.out.println(result);
            return;
        }
        // 当totalReward < 0时，证明它不是满足条件的解，不输出
        else if (totalReward < 0) {
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                // 由于有4种情况，需要clone当前的解并传入被调用的函数
                ArrayList<Long> newResult = (ArrayList<Long>)(result.clone());
                // 记录当前的选择，解决一点问题
                newResult.add(rewards[i]);
                // 剩下的问题，留给嵌套调用去解决
                get(totalReward - rewards[i], newResult);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Long> result = new ArrayList<>();
        get(3, result);
    }
}
