package org.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:WangQian
 * Date:18-6-5
 */
public interface IDoInf {
    String dosth(Method m, String mess) throws InvocationTargetException, IllegalAccessException;
}
