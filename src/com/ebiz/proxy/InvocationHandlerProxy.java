/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.proxy.service<br/>
 * FileName: MyInvocationHandler.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.ebiz.proxy.service.OperationService;
import com.ebiz.proxy.service.impl.OperationServiceImpl;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa
 * @date 2017年12月6日
 * @version 1.0
 */
public class InvocationHandlerProxy implements InvocationHandler{

    private Object target;
    
    public InvocationHandlerProxy() {}
    
    public InvocationHandlerProxy(Object target){
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 【方法功能描述】
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     * @date 2017年12月6日
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public static void main(String[] args) {
        OperationService service = new OperationServiceImpl();
        InvocationHandlerProxy proxy = new  InvocationHandlerProxy (service);
        Class<OperationService>[] clazz = new Class[] {OperationService.class};
        OperationService aopService = (OperationService) Proxy.newProxyInstance(OperationService.class.getClassLoader(), clazz, proxy);
        aopService.doOperate();
        System.out.println("-------------------------------------------------");
        aopService = (OperationService) Proxy.newProxyInstance(OperationService.class.getClassLoader(), clazz, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("beforex");
                Object result = method.invoke(new OperationServiceImpl(), args);
                System.out.println(result);
                System.out.println("end");
                return result;
            }});
        aopService.doOperate();
    }
}
