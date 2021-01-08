/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */
package org.itutopia.thinking.in.spring.ioc.overview.container;

import org.itutopia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Description IoC容器示例
 *  注解能力 {@link org.springframework.context.ApplicationContext} 作为IoC容器
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/6
 * @since
 */
public class AnnotationApplicationAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext  applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 AnnotationConfigApplicationContext 作为配置类(Configuration Class)
        applicationContext.register(AnnotationApplicationAsIoCContainerDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);

        // 关闭应用上下文
        applicationContext.stop();
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User集合对象" + users);
        }
    }

    // 通过Java注解的方式, 定义一个Bean
    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("李俊超");
        return  user;
    }

}
