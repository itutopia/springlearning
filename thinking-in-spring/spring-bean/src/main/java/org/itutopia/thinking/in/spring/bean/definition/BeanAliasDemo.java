/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */
package org.itutopia.thinking.in.spring.bean.definition;

import org.itutopia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description Bean别名示例
 * 场景化更实用
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/8
 * @since
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User sysUser = beanFactory.getBean("sys-user", User.class);

        System.out.println( user == sysUser);

    }
}
