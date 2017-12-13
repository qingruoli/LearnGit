/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.entity<br/>
 * FileName: Person.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.entity;

import com.ebiz.test.Random;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa
 * @date 2017年12月13日
 * @version 1.0
 */
public class Person {

    private String name;

    public Person(){
    }
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        Random random = new Random();
        return "I am a person, my name is " + name;
    }
}
