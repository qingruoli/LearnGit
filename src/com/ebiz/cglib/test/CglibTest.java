/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.cglib.test<br/>
 * FileName: cglibTest.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.cglib.test;

import com.ebiz.cglib.Filter.DaoFilter;
import com.ebiz.cglib.Proxy.DaoAnotherProxy;
import com.ebiz.cglib.Proxy.DaoProxy;
import com.ebiz.cglib.dao.BaseDao;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa
 * @date 2017年12月18日
 * @version 1.0
 */
public class CglibTest {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        DaoProxy daoProxy = new DaoProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BaseDao.class);
        enhancer.setCallback(daoProxy);
        BaseDao dao = (BaseDao) enhancer.create();
        dao.update();
        dao.select();
    }

    public static void test2() {
        System.setProperty("sun.misc.proxyGenerator.saveGeneratedFiles", "true");
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy anotherProxy = new DaoAnotherProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BaseDao.class);
        enhancer.setCallbacks(new Callback[] {daoProxy, anotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());
        enhancer.setInterceptDuringConstruction(false);
        BaseDao dao = (BaseDao) enhancer.create();
        dao.select();
        dao.update();
        dao.init();
    }
}
