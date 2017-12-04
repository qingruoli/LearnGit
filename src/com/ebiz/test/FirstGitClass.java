package com.ebiz.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstGitClass {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator);
            String item = iterator.next();
            if (item == "1") {
                iterator.remove();
            }
        }
        System.out.println(list);
        /*for (String item : list) {
            System.out.println(item);
            if ("2".equals(item)) {
                list.remove(item);
            }
        }*/
    }
}
