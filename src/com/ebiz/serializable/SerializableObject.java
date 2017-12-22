/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package: com.ebiz.serializable<br/>
 * FileName: SerializableObject.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Java 序列化和反序列化
 *
 * @author cao.qifa
 * @date 2017年12月12日
 * @version 1.0
 */
public class SerializableObject implements Serializable {

    /**
     * 【变量说明】
     */
    private static final long serialVersionUID = 1L;

    private String str0;

    private transient String str1;

    private static String str2 = "abc";

    public SerializableObject(String str0, String str1){
        this.str0 = str0;
        this.str1 = str1;
    }

    public String getStr0() {
        return str0;
    }

    public String getStr1() {
        return str1;
    }
    
    // 进行序列化、反序列化时，虚拟机会首先试图调用对象里的writeObject和readObject方法，进行用户自定义的序列化和反序列化。
    // 如果没有这样的方法，那么默认调用的是ObjectOutputStream的defaultWriteObject以及ObjectInputStream的defaultReadObject方法。
    // 换言之，利用自定义的writeObject方法和readObject方法，用户可以自己控制序列化和反序列化的过程。
    private void writeObject(java.io.ObjectOutputStream s) throws Exception {
        System.out.println("我想自己控制序列化的过程");
        s.defaultWriteObject();
        s.writeInt(str1.length());
        for (int i = 0;i < str1.length();i++)
            s.writeChar(str1.charAt(i));
    }

    private void readObject(java.io.ObjectInputStream s) throws Exception {
        System.out.println("我想自己控制反序列化的过程");
        s.defaultReadObject();
        int length = s.readInt();
        char[] cs = new char[length];
        for (int i = 0;i < length;i++)
            cs[i] = s.readChar();
        str1 = new String(cs, 0, length);
    }
    
    
    public static void main(String[] args) throws Exception{
        File file = new File("D:" + File.separator + "s.txt");
        System.out.println(file.getPath());
        OutputStream os = new FileOutputStream(file);  
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(new SerializableObject("str0", "str1"));
        oos.close();

        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        SerializableObject so = (SerializableObject)ois.readObject();
        System.out.println("str0 = " + so.getStr0());
        System.out.println("str1 = " + so.getStr1());
        ois.close();
    }
}
