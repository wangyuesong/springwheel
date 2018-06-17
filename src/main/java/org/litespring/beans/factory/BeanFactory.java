package org.litespring.beans.factory;

import org.litespring.beans.BeanDefinition;

// Read defintition and create object accordingly
public interface BeanFactory {
    BeanDefinition getBeanDefinition(String petStore);

    Object getBean(String beanId);
}
