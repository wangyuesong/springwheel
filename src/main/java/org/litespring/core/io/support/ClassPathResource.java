package org.litespring.core.io.support;

import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

import java.io.InputStream;

public class ClassPathResource implements Resource {
    private String configFilePath;
    private ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

    public ClassPathResource(String s, ClassLoader classLoader) {
        this.configFilePath = s;
        this.classLoader = classLoader;
    }

    public ClassPathResource(String s) {
        configFilePath = s;
    }

    public InputStream getInputStream() {
        ClassLoader cl = this.classLoader;
        return cl.getResourceAsStream(configFilePath);
    }
}
