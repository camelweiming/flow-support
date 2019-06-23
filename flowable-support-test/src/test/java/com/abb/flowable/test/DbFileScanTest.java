package com.abb.flowable.test;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DbFileScanTest {
    @Test
    public void test() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 获取多个文件
        Resource[] resources = resolver.getResources("classpath*:**/*.sql");
        for (Resource r : resources) {
            if (!r.getFilename().startsWith("flowable.mysql.create")) {
                continue;
            }
            IOUtils.write(IOUtils.toByteArray(r.getURL()), new FileOutputStream(new File("/Users/luoweiming/data/" + r.getFilename())));
        }
    }


}
