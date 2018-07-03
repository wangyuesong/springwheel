package org.litespring.beans.support;

import org.litespring.beans.factory.BeanFactory;

// This class is used to resolve <property> tag's value
public class BeanDefinitionValueResolver {
    private BeanFactory beanFactory;
    public BeanDefinitionValueResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference reference = (RuntimeBeanReference)value;
            return beanFactory.getBean(reference.getBeanName());
        }
        else if (value instanceof TypedStringValue) {
            TypedStringValue typedStringValue = (TypedStringValue)value;
            return typedStringValue.getValue();
        }
        else {
            throw new RuntimeException("Type not supported yet");
        }
    }
}
