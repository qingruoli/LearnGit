/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.cloneAble<br/>
 * FileName: CloneTest.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.cloneAble;

import com.ebiz.entity.Person;
import com.ebiz.entity.SimpleObject;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa
 * @date 2017年12月13日
 * @version 1.0
 */
public class CloneTest {

    public static void main(String[] args) throws Exception {
        SimpleObject so0 = new SimpleObject();
        Person p = new Person("asd");
        so0.setStr("111");
        so0.setPerson(p);
        SimpleObject so1 = (SimpleObject) so0.clone();
        System.out.println("so0 == so1?" + (so0 == so1));
        System.out.println("so0.getClass() == so1.getClass()?" + (so0.getClass() == so1.getClass()));
        System.out.println("so0.equals(so1)?" + (so0.equals(so1)));
        so1.setStr("222");
        System.out.println("so0.getStr()：" + so0.getStr());
        System.out.println("so1.getStr()：" + so1.getStr());
        Person p1 = so1.getPerson();
        System.out.println("p == p1" + (p == p1));
        p1.setName("changed name.");
        System.out.println("so0.getPerson()：" + so0.getPerson());
        System.out.println("so1.getPerson()：" + so1.getPerson());
    }
}
