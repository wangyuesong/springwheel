package org.litespring.beans.factory.support;

import org.litespring.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// This stores the singleton bean created, indexed by beanName
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    public void registerSingleton(String beanName, Object singletonObject) {
        Object oldObject = this.singletonMap.get(beanName);
        if (oldObject != null) {
            throw new IllegalStateException("Could not register object [" + singletonObject + "] under " +
                    "bean name " + beanName + " because it's already registered as object [" + oldObject + "]");
        }
        this.singletonMap.put(beanName, singletonObject);
    }

    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }
}
