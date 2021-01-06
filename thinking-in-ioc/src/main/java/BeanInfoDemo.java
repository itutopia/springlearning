/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @Description 示例
 * PropertyDescriptor
 *
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/6
 * @since
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {

        // 任何类的父类都是Object类
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        //Lambda表达式
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    //PropertyDescriptor 允许添加属性编辑器-PropertyEditor
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)){
                        // String-->Integer
                        // Integer.valueOf("")
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        propertyDescriptor.createPropertyEditor(Person.class);
                    }
                    System.out.println(propertyDescriptor);
                });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        @Override
        public void  setAsText(String text){
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
