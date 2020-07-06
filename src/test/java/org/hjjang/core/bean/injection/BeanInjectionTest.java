//package org.hjjang.core.bean.injection;
//
//import org.hjjang.component.DIComponent;
//import org.hjjang.component.DIManageService;
//import org.hjjang.core.bean.collection.BeanCollection;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//
//class BeanInjectionTest {
//
//    @Test
//    @DisplayName("Inject 테스트")
//    public void injectTest() throws InstantiationException, IllegalAccessException {
//        BeanInjection bi = new BeanInjection();
//
//        BeanCollection.registBean(DIManageService.class.getName(),DIManageService.class.newInstance());
//        BeanCollection.registBean(DIComponent.class.getName(),DIComponent.class.newInstance());
//
//        bi.injectDI();
//
//        String beanName = DIManageService.class.getName();
//        Object bean = BeanCollection.getInjectBean(beanName);
//        assertEquals("diComponent",((DIManageService)bean).getUserInfo());
//
//    }
//}