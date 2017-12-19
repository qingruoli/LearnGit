/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.cglib.dao<br/>
 * FileName: BaseDao.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.cglib.dao;


/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年12月18日 
 * @version 1.0
 */
public class BaseDao {
    
    public BaseDao() {
        init();
    }
    
    public void update() {
        System.out.println("PeopleDao.update()");
    }
    
    public void select() {
        System.out.println("PeopleDao.select()");
    }
    
    public void init() {
        System.out.println("initializating.");
    }
}
