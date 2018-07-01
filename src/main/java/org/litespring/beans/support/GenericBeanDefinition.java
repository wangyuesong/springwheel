package org.litespring.beans.support;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;
    private String scope;
    private List<PropertyValue> propertyValues;

    // By default singleton
    private boolean singleton = true;
    private boolean prototype = false;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
        this.propertyValues = new ArrayList<>();
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }
}
