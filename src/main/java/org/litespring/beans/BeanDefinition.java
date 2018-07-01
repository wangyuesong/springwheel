package org.litespring.beans;

import java.util.List;

public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static String SCOPE_DEFAULT = "";

    String getBeanClassName();

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

    void setScope(String scope);

    List<PropertyValue> getPropertyValues();
}
