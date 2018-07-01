package org.litespring.beans.factory.config;

// This interface describe the ability to register a singleton bean
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
