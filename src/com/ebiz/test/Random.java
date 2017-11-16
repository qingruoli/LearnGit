/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.test<br/>
 * FileName: Random.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.test;


/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年10月12日 
 * @version 1.0
 */
public class Random {
    public static void main(String[] args) {
        for(int i = 0; i < 16; i ++) {
            int x = (int) (Math.random() * 63);
            char a =  (char) (x + 65);
            System.out.print(a);
        }
        // 加密orderNo的aesKey: cXBpekIXvxPDoqjK
        // sign的MD5Key: 7568zh
        // 加密userName的nameMD5Key: 186060139d862835508zhys67dead6d4
        // 核保接口: http://m.evergrandelife.com.cn/thirdOrderUwService
        // 支付接口： http://m.evergrandelife.com.cn/orderPay/postalOrderPay.action?action=postalOrderPay&orderNo=
        // comId: 8601
        
        //提交2
        //SIT ADD
    }
}
