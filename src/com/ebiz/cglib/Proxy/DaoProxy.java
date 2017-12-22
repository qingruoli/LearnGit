/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.cglib.Proxy<br/>
 * FileName: MethodInterceptor.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.cglib.Proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa
 * @date 2017年12月18日
 * @version 1.0
 */
public class DaoProxy implements MethodInterceptor {

    /**
     * 代理方法
     *
     * @param object
     * @param arg1
     * @param objects
     * @param proxy
     * @return
     * @throws Throwable
     * @date 2017年12月18日 
     */
    @Override
    public Object intercept(Object object, Method arg1, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("Before Method Invoke");
        proxy.invokeSuper(object, objects);
        System.out.println("After Method Invoke");
        return object;
    }
}
