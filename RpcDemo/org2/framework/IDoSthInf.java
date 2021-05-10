package org2.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:WangQian
 * Date:18-6-11 下午8:03
 */
public interface IDoSthInf {
    boolean IDoSth0(Method m,String mess) throws InvocationTargetException, IllegalAccessException;
    boolean IDoSth1(Method m,String mess) throws InvocationTargetException, IllegalAccessException;
    boolean IDoSth2(Method m,String mess) throws InvocationTargetException, IllegalAccessException;
    String  IDoSth3(Method m,String mess) throws InvocationTargetException, IllegalAccessException;
}
