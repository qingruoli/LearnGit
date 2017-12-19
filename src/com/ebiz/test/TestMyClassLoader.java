/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.test<br/>
 * FileName: TestMyClassLoader.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.test;

import java.net.URL;

import com.ebiz.classLoader.MyClassLoader;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年12月13日 
 * @version 1.0
 */
public class TestMyClassLoader
{
    public static void main(String[] args) throws Exception
    {
        String s = "";
        StringBuilder sbuilder = new StringBuilder();
        MyClassLoader mcl = new MyClassLoader();
        Class<?> c1 = Class.forName("com.ebiz.entity.Person", true, mcl);
        Object obj = c1.newInstance();
        System.out.println("加载类完成，OBJ=" + obj);
        System.out.println(obj.getClass().getClassLoader());
        c1 =  Class.forName("java.lang.String");
        obj = c1.newInstance();
        System.out.println(obj.getClass().getClassLoader());
        
        System.out.println("=======================类加载器=============================");
        test();
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println(System.getProperty("java.ext.dirs"));
        
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
    
    /**
     * 查看BootStrapClassLoader都加载了啥
     *
     * @date 2017年12月7日 
     */
    public static void test() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();    
        for (int i = 0; i < urls.length; i++) {    
            System.out.println(urls[i].toExternalForm());    
        }   
    }
}
