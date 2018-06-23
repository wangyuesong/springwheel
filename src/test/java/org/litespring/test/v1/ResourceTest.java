package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.Resource;
import org.litespring.core.io.support.ClassPathResource;
import org.litespring.core.io.support.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {
    @Test
    public void testClassPathResource() throws IOException {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        InputStream inputStream = resource.getInputStream();
        try {
            Assert.assertNotNull(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws IOException {
//        Resource resource = new FileSystemResource("petstore-v1.xml");
//        InputStream inputStream = resource.getInputStream();
//        try {
//            Assert.assertNotNull(inputStream);
//        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//        }
    }
}
