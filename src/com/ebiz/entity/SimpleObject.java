/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.entity<br/>
 * FileName: SimpleObject.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.entity;


/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年12月13日 
 * @version 1.0
 */
public class SimpleObject implements Cloneable{
    private String str;
    private Person person;
    
    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }
    
    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }
    
    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }
    
    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
    public SimpleObject clone() throws CloneNotSupportedException {
        return (SimpleObject)super.clone();
    }
    
}
