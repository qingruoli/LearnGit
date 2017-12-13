/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.classLoader<br/>
 * FileName: MyClassLoader.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa
 * @date 2017年12月13日
 * @version 1.0
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader(){
    }

    public MyClassLoader(ClassLoader parent){
        super(parent);
    }

     // 1、如果不想打破双亲委派模型，那么只需要重写findClass方法即可
     // 2、如果想打破双亲委派模型，那么就重写整个loadClass方法
    /**
     * @param name
     * @return
     * @throws ClassNotFoundException
     * @date 2017年12月13日
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("D:\\workspace\\LearnGit\\Person.class");
        Class<?> clazz = null;
        try {
            byte[] bytes = getClassBytes(file);
            clazz = this.defineClass(name, bytes, 0, bytes.length);
        }
        catch (Exception e) {
            e.printStackTrace();
            clazz = super.findClass(name);
        }
        return clazz;
    }
    
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if("com.ebiz.entity.Person".equals(name)) {
            System.out.println("尝试加载class:" + name);
        }
        return super.loadClass(name);
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);
        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }
}
