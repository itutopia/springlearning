package org.itutopia.thinking.in.spring.bean.definition;/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */

import org.itutopia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Description 注解 BeanDefinition 示例
 * 兜底方案
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/8
 * @since
 */
// 3. 通过 @Impoort 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class(配置类)
        applicationContext.register(Config.class);
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        // 1. 通过 @Bean 方式定义
        // 2. 通过 @Component 方法
        // 3. 通过 @Impoort 来进行导入

        // 启动应用上下文
        applicationContext.refresh();

        // 按照类型依赖朝招
        System.out.println("config 类型的所有Bean" + applicationContext.getBeansOfType(Config.class));
        System.out.println("user 类型的所有Bean" + applicationContext.getBeansOfType(User.class));

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     * 命名 Bean 的注册方式
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id",1L)
                .addPropertyValue("name","李俊超");

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)){
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }
        else {
            // 非命名 Bean 方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }



    // 2. 定义 @Component 当前类作为 Spring Bean(组件方式)
    @Component
    public static class Config {
        /**
         * 1. 通过 Java 注解的方式, 定义了一个 Bean
         * @return
         */
        @Bean(name={"user","sys-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("李俊超");
            return user;
        }
    }
}
