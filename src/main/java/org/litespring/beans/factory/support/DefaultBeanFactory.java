package org.litespring.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.util.ClassUtils;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private ClassLoader classLoader;

    public static final String ID_ATTRIBUTE = "id";

    public static final String CLASS_ATTRIBUTE = "class";

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    public BeanDefinition getBeanDefinition(String beanID) {
        return this.beanDefinitionMap.get(beanID);
    }

    public void registerBeanDefinition(String id, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(id, beanDefinition);
    }

    // get bean by id, first read def
    // then depends on if it's singleton or not
    // read from different map
    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if(bd == null) {
            throw new BeanCreationException("Bean Definition does not exist");
        }
        if (bd.isSingleton()) {
            if (this.getSingleton(beanID) == null) {
                this.registerSingleton(beanID, this.createBean(bd));
            }
            return this.getSingleton(beanID);
        }
        return createBean(bd);
    }

    // Create a bean based on def
    private Object createBean(BeanDefinition bd) {
        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("Bean created failed for " + beanClassName);
        }
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.classLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return this.classLoader == null ? ClassUtils.getDefaultClassLoader(): this.classLoader;
    }
}
