/**
 * Copyright (c) 2020  邯郸新港网络科技有限公司 All rights reserved.
 * https://www.xingangnet.com
 * 版权所有，侵权必究！
 */

/**
 * @Description JavaBean POJO类
 *
 * Setter  /  Getter
 * 可写方法(Writable) / 可读方法(Readable)
 * @Author <a href="mailto:ljch867@163.com">Junchao_Lee</a>
 * @date 2021/1/6
 * @since
 */
public class Person {


    // Property
    //String to String
    private String name;

    //String to Integer
    private Integer age;

    // Method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
