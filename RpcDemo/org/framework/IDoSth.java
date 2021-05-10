package org.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public abstract class IDoSth implements IDoInf {
    @Override
    public String dosth(Method m, String mess) throws InvocationTargetException, IllegalAccessException {
       String[] params = mess.split("\\|");
       String param1 = params[2];
       String param2 = params[3];
       boolean res = (boolean)m.invoke(this,param1,param2);
        System.out.println("IDoSth.dosth " +res);
       if(res){
           return "OK";
       }else{
           return "ERROR";
       }
    }
}
