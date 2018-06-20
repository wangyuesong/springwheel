package org.litespring.beans.factory;

import org.litespring.beans.BeanDefinition;

// Read defintition and create object accordingly
public interface BeanFactory {
    Object getBean(String beanId);
}
