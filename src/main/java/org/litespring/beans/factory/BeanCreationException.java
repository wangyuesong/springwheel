package org.litespring.beans.factory;

import org.litespring.beans.BeansException;

public class BeanCreationException extends BeansException {
    public BeanCreationException(String message) {
        super(message);
    }
}
