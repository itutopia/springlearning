/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */
package org.itutopia.thinking.in.spring.bean.definition;

import org.itutopia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Description Bean 构建示例
 *
 *
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/6
 * @since
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1. 通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
//        beanDefinitionBuilder.addPropertyValue("id",1);
//        beanDefinitionBuilder.addPropertyValue("name","李俊超");

        beanDefinitionBuilder.addPropertyValue("id",1)
                .addPropertyValue("name","李俊超");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();



        // 2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();

//        propertyValues.addPropertyValue("id",1);
//        propertyValues.addPropertyValue("name","李俊超");

        propertyValues.add("id",1).
                add("name","李俊超");

        //通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
