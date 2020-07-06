package org.hjjang.core.bean.injection;

import org.hjjang.core.annotation.Autowired;
import org.hjjang.core.bean.collection.BeanCollection;

import java.lang.reflect.Field;
import java.util.List;

public class BeanInjection {

    public void injectDI() throws IllegalAccessException, InstantiationException {
        List<Object> beanList = BeanCollection.getBeanList();

        for(Object bean : beanList){
            Object beanInstance = getFieldList(bean);
            BeanCollection.registInjectBean(bean.getClass().getName(),beanInstance);
        }

    }

    private Object getFieldList(Object bean) throws IllegalAccessException, InstantiationException {
//        Object instance = org.hjjang.core.bean.newInstance();
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            boolean hasAutowiredAnnotaion = hasAutowiredAnnotaion(field);

            if(hasAutowiredAnnotaion){
                Class<?> type = field.getType();

                Object typeBean = BeanCollection.getBean(type.getName());

                field.setAccessible(true);
                field.set(bean,typeBean);
            }
        }

        return bean;

    }

    private boolean hasAutowiredAnnotaion(Field field) {
        boolean hasAutowired = false;
        Autowired declaredAnnotation = field.getDeclaredAnnotation(Autowired.class);
        if(declaredAnnotation != null){
            Class<?> fieldType = field.getType();
            return true;
        }
        return hasAutowired;
    }
}
