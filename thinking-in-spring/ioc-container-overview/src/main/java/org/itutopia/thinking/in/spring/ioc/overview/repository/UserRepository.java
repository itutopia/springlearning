/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */
package org.itutopia.thinking.in.spring.ioc.overview.repository;

import javafx.application.Application;
import org.itutopia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.beans.beancontext.BeanContext;
import java.util.Collection;

/**
 * @Description 用户信息仓库
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/6
 * @since
 */
public class UserRepository {

    // 定义Bean
    private Collection<User> users;

    // 内建Bean
    private BeanFactory beanFactory;

    //
    private ObjectFactory<User> userObjectFactory;

    private ObjectFactory<Application> applicationObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }


    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    public ObjectFactory<Application> getApplicationObjectFactory() {
        return applicationObjectFactory;
    }

    public void setApplicationObjectFactory(ObjectFactory<Application> applicationObjectFactory) {
        this.applicationObjectFactory = applicationObjectFactory;
    }
}
