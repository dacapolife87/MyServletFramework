package org.hjjang.core.bean;

import org.hjjang.core.annotation.Bean;
import org.hjjang.core.bean.collection.BeanCollection;
import org.reflections.Reflections;

import java.util.Set;

public class BeanLoader {

    public void beanProcessor() throws InstantiationException, IllegalAccessException {
        loader();
    }
    public void loader() throws IllegalAccessException, InstantiationException {
        Reflections reflector = new Reflections("");

        Set<Class<?>> classSet = reflector.getTypesAnnotatedWith(Bean.class);

        System.out.println("BeanList!");
        for(Class clazz : classSet){
            System.out.println(clazz.getName());
            System.out.println(clazz.isAnnotation());
            BeanCollection.registBean(clazz.getName(),clazz.newInstance());
        }
    }
}
