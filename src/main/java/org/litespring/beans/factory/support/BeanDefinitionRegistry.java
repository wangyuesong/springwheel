package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

// This interface should goes into support
// as it's related with implementation
// (it's for interface separation), it's not
// going to expose to client
public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String id);

    void registerBeanDefinition(String id, BeanDefinition beanDefinition);
}
