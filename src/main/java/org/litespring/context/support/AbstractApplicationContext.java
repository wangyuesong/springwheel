package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;

public abstract  class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;
    AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        Resource resource = getResourceByPath(configFile);
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
    }

    // TemplateMethod!
    protected abstract Resource getResourceByPath(String configFile);
}
