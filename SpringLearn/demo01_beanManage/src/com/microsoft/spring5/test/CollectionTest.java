package com.microsoft.spring5.test;

import com.microsoft.spring5.CollectionBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionTest {
    @Test
    public void testCollections() {
        ApplicationContext collectionContext = new ClassPathXmlApplicationContext("bean3.xml");

        CollectionBean collectionBean = collectionContext.getBean("col", CollectionBean.class);

        System.out.println(collectionBean);
    }


}
