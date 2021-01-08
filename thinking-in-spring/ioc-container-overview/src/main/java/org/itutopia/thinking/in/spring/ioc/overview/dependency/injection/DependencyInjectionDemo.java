/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */
package org.itutopia.thinking.in.spring.ioc.overview.dependency.injection;

import org.itutopia.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Description 依赖注入示例
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/6
 * @since
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置XML配置文档
        //启动 Spring 应用上下文
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository",UserRepository.class);
        System.out.println(userRepository.getUsers());

        //依赖注入 (内建依赖)
        System.out.println(userRepository.getBeanFactory());

        // beanFactory?
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = userRepository.getUserObjectFactory();
        System.out.println(userFactory.getObject() == applicationContext);

        // 容器内建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取容器内建Environment类型的Bean" + environment);

        whoIsIocContainer(userRepository,applicationContext);
    }


    private static void whoIsIocContainer(UserRepository userRepository, ApplicationContext applicationContext){

        // 这个表达式为什么不成立? false
        System.out.println(userRepository.getBeanFactory() == applicationContext);

    }
}
