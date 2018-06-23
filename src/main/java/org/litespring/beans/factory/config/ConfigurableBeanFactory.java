package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

// We want to keep the cleaness of BeanFactory(it's for client use)
// And we want the class loader(used by ClassPathResource & DefaultBeanFactory when creating Bean)
// etc to be configurable. Thus we extends this BeanFactory with two methods
public interface ConfigurableBeanFactory extends BeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
