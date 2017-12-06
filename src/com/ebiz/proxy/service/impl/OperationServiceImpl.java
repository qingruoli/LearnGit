/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.proxy.service.impl<br/>
 * FileName: OperationServiceImpl.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.proxy.service.impl;

import com.ebiz.proxy.service.OperationService;

/**
 * 被代理服务类
 *
 * @author cao.qifa
 * @date 2017年12月6日
 * @version 1.0
 */
public class OperationServiceImpl implements OperationService {

    /**
     * 被代理类的方法
     *
     * @date 2017年12月6日
     */
    @Override
    public String doOperate() {
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < 10;i++) {
            if (i % 2 == 0) {
                res.append(i);
            }
        }
        System.out.println("result:" + res.toString());
        return res.toString();
    }
}
