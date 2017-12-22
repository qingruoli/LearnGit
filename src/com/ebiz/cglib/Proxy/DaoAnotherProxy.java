/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.cglib.Proxy<br/>
 * FileName: DaoAnotherProxy.java<br/>
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
public class DaoAnotherProxy implements MethodInterceptor {

    /**
     * 代理指定方法的代理方法
     *
     * @param object
     * @param method
     * @param objects
     * @param methodproxy
     * @return
     * @throws Throwable
     * @date 2017年12月18日
     */
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
        proxy.invokeSuper(object, objects);
        System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
        return object;
    }
}
