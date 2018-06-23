package org.litespring.context;

import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;

// Application context is mostly a delegation of BeanFactory for client's easy to
// use
public interface ApplicationContext extends ConfigurableBeanFactory {
}
