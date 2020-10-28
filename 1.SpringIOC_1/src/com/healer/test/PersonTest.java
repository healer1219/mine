package com.healer.test;

import com.healer.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 存在的几个问题
 *  1） 我们将源码包（src）开始的路径称为类路径的开始
 *      所有源码包内的文件都会被合并放在类路径下
 *  2） 导包 commons-logging-1.1.3.jar （依赖）
 *  3） 先导包再创建配置文件
 *  4）spring容器接管了标志了s的类
 *
 *
 * 几个细节：
 *  1） ApplicationContext（IOC容器的接口）
 *          new ClassPathXmlApplicationContext("ioc.xml"); ==> ioc的配置文件在类路径下
 *          new FileSystemXmlApplicationContext("D://ioc.xml") ==> ioc的配置文件在文件系统路径下
 *  2） 给容器中注册一个组件，根据id拿到这个组件的对象
 *          容器负责对象的创建
 *          容器中对象的创建在容器创建完成的时候就已经创建好了
 *
 *  3） 同一个组件在ioc中是单实例的；容器启动完成之前就已经创建好了
 *
 *  4) 容器中如果没有这个组件，会报 NoSuchBean 异常
 *
 *  5）容器在创建一个组件对象时候，会利用其setter方法为JavaBean的属性进行赋值
 *
 *  6） JavaBean的属性名是由getterSetter方法决定的
 */

/**
 * 从容器中拿到组件
 */
public class PersonTest {

    @Test
    public void getPerson(){
        //ApplicationContext：代表了ioc容器
        //ClassPathApplicationContext：当前应用的xml配置文件在ClassPath下
        //根据spring的配置文件得到ioc对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

        System.out.println("容器创建完成");

        //从容器中取得容器自动创建的对象
        Person person01 = (Person) ioc.getBean("Person01");

        System.out.println(person01);

    }
}
