package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {
    protected DefaultBeanFactory factory = null;
    private ClassLoader classLoader;

    AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        Resource resource = getResourceByPath(configFile);
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
        factory.setBeanClassLoader(this.classLoader);
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.classLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return this.classLoader == null ? ClassUtils.getDefaultClassLoader(): this.classLoader;
    }

    // TemplateMethod!
    protected abstract Resource getResourceByPath(String configFile);
}
