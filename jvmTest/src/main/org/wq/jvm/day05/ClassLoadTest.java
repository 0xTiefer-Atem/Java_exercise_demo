package org.wq.jvm.day05;

/**
 * @Author WangQian
 * @Date 2020/10/11 下午 4:44
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不同的类加载器对instanceof关键字运算的结果的影响
 */
public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("org.wq.jvm.day05.ClassLoadTest");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoadTest);
    }
}
