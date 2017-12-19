/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.cglib.Filter<br/>
 * FileName: DaoFilter.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.cglib.Filter;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年12月18日 
 * @version 1.0
 */
public class DaoFilter implements CallbackFilter{

    /**
     * 【方法功能描述】
     *
     * @param method
     * @return
     * @date 2017年12月18日 
     */
    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
    
}
