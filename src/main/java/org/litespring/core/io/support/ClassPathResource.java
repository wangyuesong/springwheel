package org.litespring.core.io.support;

import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

import java.io.InputStream;

public class ClassPathResource implements Resource {
    private String configFilePath;

    public ClassPathResource(String s) {
        configFilePath = s;
    }

    public InputStream getInputStream() {
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        return cl.getResourceAsStream(configFilePath);
    }
}
