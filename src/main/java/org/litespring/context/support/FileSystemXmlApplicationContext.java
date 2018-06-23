package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.core.io.Resource;
import org.litespring.core.io.support.FileSystemResource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {
    private DefaultBeanFactory factory;

    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourceByPath(String configFile) {
        return new FileSystemResource(configFile);
    }

    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }

}
