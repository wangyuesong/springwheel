package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.core.io.support.ClassPathResource;

// Glue: read xml and get bean functions
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourceByPath(String configFile) {
        return new ClassPathResource(configFile, this.getBeanClassLoader());
    }

    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}
