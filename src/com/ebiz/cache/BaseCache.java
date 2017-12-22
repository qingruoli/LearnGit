/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.cache<br/>
 * FileName: BaseCache.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.map.LazyMap;

/**
 * 【类或接口功能描述】
 *
 * @author cao.qifa 
 * @date 2017年12月4日 
 * @version 1.0
 * @param <T>
 */
public abstract class BaseCache<T> {
    private static final List<BaseCache> cacheList = new ArrayList<>();
    
    private Map<String[], Object> keyToRecMap = new HashMap<>();
    @SuppressWarnings("unchecked")
    private Map<String[], List<T>> keyToResMap = LazyMap.decorate(keyToRecMap, new Transformer() {
        @Override
        public List<T> transform(Object obj) {
            List<T> resList = getObject((Object[]) obj);
            return resList;
        }
        
    });
    
    protected BaseCache(){
        cacheList.add(this);
    }
    
    public abstract List<T> getObject(Object[] obj);
    
    public List<T> getList(Object... params) {
        return keyToResMap.get(params);
    }
    static class CacheImpl extends BaseCache<String>{

        /**
         * 【方法功能描述】
         *
         * @param obj
         * @return
         * @date 2017年12月5日 
         */
        @Override
        public List<String> getObject(Object[] obj) {
            List<String> resultList = new ArrayList<>();
            if(obj != null) {
                if(obj.length == 0) {
                    resultList.add("default.");
                } else if(obj instanceof String[]) {
                    StringBuilder sBuilder = new StringBuilder();
                    for(int i = 0; i < obj.length; i ++) {
                        sBuilder.append(obj[i]).append(" ");
                    }
                    resultList.add(sBuilder.toString());
                } else {
                    resultList.add(obj.getClass().getName());
                }
            }
            return resultList;
        }
    }
    public static void main(String[] args) {
        BaseCache<String> cache = new CacheImpl();
        BaseCache<String> cache1 = new CacheImpl();
        String[] str = {"hello", "Java"};
        List<String> res = cache.getList(str);
//        System.out.println(res);
        str = new String[]{};
        List<String> res1 = cache.getList(str);
        List<String> res2 = cache1.getList(null);
//        System.out.println(res1);
//        System.out.println(res2);
        /*Iterator<Map.Entry<String[], List<String>>> it = cache.keyToResMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String[], List<String>> entry = it.next();
            List<String> value = entry.getValue();
            String[] key = entry.getKey();
            StringBuilder keyEntity = new StringBuilder(); 
            for(int i = 0; i < key.length; i ++) {
                keyEntity.append(key[i]).append("_");
            }
            System.out.println(keyEntity + ":" + value);
        }*/
        for(BaseCache base : BaseCache.cacheList) {
            System.err.println(base + "\n-----------------------------");
            Iterator<Map.Entry<String[], List<String>>> its = base.keyToResMap.entrySet().iterator();
            while(its.hasNext()) {
                Map.Entry<String[], List<String>> entry = its.next();
                List<String> value = entry.getValue();
                String[] key = entry.getKey() == null ? new String[]{"NULL"} : entry.getKey();
                StringBuilder keyEntity = new StringBuilder(); 
                for(int i = 0; i < key.length; i ++) {
                    keyEntity.append(key[i]).append("_");
                }
                System.err.println(keyEntity + ":" + value);
            }
        }
    }
}
