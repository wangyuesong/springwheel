package org.litespring.test.v1;

import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.service.v1.PetStoreService;

import static org.junit.Assert.*;

public class BeanFactoryTest {
    private DefaultBeanFactory factory = null;
    private XmlBeanDefinitionReader xmlBeanDefinitionReader = null;

    @Before
    public void setup() {
        factory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
    }

    // Read a bean definition, get it's definition and create one bean
    @Test
    public void testGetBean() {
        xmlBeanDefinitionReader.loadBeanDefinition("petstore-v1.xml");

        BeanDefinition beanDefinition = factory.getBeanDefinition("petStore");
        assertEquals("org.litespring.service.v1.PetStoreService", beanDefinition.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

        assertNotNull(petStore);
    }

    // Should throw bean creation exception
    @Test
    public void testInvalidBean() {
        xmlBeanDefinitionReader.loadBeanDefinition("petstore-v1.xml");
        try {
            factory.getBean("invalidBeanDefinition");
        } catch (BeanCreationException b) {
            return;
        }
        fail("Should throw BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            xmlBeanDefinitionReader.loadBeanDefinition("asd-v1.xml");
        } catch (BeanDefinitionStoreException b) {
            return;
        }
        fail("Should throw BeanCreationException");
    }

}
