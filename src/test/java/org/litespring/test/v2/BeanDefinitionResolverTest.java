package org.litespring.test.v2;

import org.junit.Test;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.beans.support.BeanDefinitionValueResolver;
import org.litespring.beans.support.RuntimeBeanReference;
import org.litespring.core.io.support.ClassPathResource;
import org.litespring.dao.v2.AccountDao;
import org.litespring.util.Assert;

public class BeanDefinitionResolverTest {
    @Test
    public void testResolveRuntimeBeanReference() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        // Factory knows id -> bean def, id -> real bean
        // Resolver takes charge of bean name -> real bean
        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);

        RuntimeBeanReference reference = new RuntimeBeanReference("accountDao");
        Object value = resolver.resolveValueIfNecessary(reference);

        Assert.notNull(value, "should not be null");
        org.junit.Assert.assertTrue(value instanceof AccountDao);
    }
}
