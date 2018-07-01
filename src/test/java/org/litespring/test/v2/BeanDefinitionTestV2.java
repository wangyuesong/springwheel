package org.litespring.test.v2;

import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.support.RuntimeBeanReference;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.beans.support.TypedStringValue;
import org.litespring.core.io.support.ClassPathResource;
import static org.junit.Assert.*;

public class BeanDefinitionTestV2 {
    @Test
    public void testGetBeanDefinition() {
        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);

        xmlBeanDefinitionReader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition("petStore");

        assertEquals(3, beanDefinition.getPropertyValues().size());

        assertTrue(beanDefinition.getPropertyValues().stream().filter(pv -> pv.getName().equals("itemDao")).findFirst().get().getValue() instanceof RuntimeBeanReference);

        assertTrue(beanDefinition.getPropertyValues().stream().filter(pv -> pv.getName().equals("petstoreName")).findFirst().get().getValue() instanceof TypedStringValue);
    }
}
