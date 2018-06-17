package org.litespring.test.v1;

import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.service.v1.PetStoreService;

import static org.junit.Assert.*;

public class BeanFactoryTest {
    // Read a bean definition, get it's definition and create one bean
    @Test
    public void testGetBean() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition beanDefinition = factory.getBeanDefinition("petStore");
        assertEquals("org.litespring.service.v1.PetStoreService", beanDefinition.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

        assertNotNull(petStore);
    }

    // Should throw bean creation exception
    @Test
    public void testInvalidBean() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        try {
            factory.getBean("invalidBeanDefinition");
        } catch (BeanCreationException b) {
            return;
        }
        fail("Should throw BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        try {
            factory.getBean("invalidBeanDefinition");
        } catch (BeanCreationException b) {
            return;
        }
        fail("Should throw BeanCreationException");
    }

}
