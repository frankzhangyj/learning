package com.microsoft.spring5.test;

import com.microsoft.spring5.autoWire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.net.util.IPAddressUtil;

public class AutoWireTest {
    @Test
    public void testAutoWire() {
        ApplicationContext autoWireContext = new ClassPathXmlApplicationContext("bean7.xml");
        Emp empt = autoWireContext.getBean("empt", Emp.class);

        System.out.println(empt);
    }
}
