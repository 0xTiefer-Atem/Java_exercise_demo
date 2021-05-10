package org2.idl;

import org2.framework.IDoSthInf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:WangQian
 * Date:18-6-11 下午8:05
 */

public class MyDoSth implements IDoSthInf {

    /*
    * no parameter
    *
    * */
    @Override
    public boolean IDoSth0(Method m, String mess){
        System.out.println("MyDoSth.IDoSth0  " +mess);
        return true;
    }


    /*
    * parameter is one
    * */
    @Override
    public boolean IDoSth1(Method m, String mess) throws InvocationTargetException, IllegalAccessException {
        System.out.println("MyDoSth.IDoSth1  " +mess);
        String[] params = mess.split("\\|");
        String para = params[1];
        boolean b = (boolean)m.invoke(this,para);
        return b;
    }

    /*
     * two parameters
     * */
    @Override
    public boolean IDoSth2(Method m, String mess) throws InvocationTargetException, IllegalAccessException {
        System.out.println("MyDoSth.IDoSth2  " +mess);
        String[] params = mess.split("\\|");
        String para1 = params[1];
        String para2 = params[2];
        System.out.println(m.getName()+"==========");
        System.out.println(this.getClass());
        boolean b = (boolean)m.invoke(this,para1,para2);
        return b;
    }



    /*
     *three parameters
     * */
    @Override
    public String IDoSth3(Method m, String mess) throws InvocationTargetException, IllegalAccessException {
        System.out.println("MyDoSth.IDoSth3  " +mess);
        String[] params = mess.split("\\|");
        String para = params[1];
        String para1 = params[2];
        String para2 = params[3];
        String b = (String)m.invoke(this,para,para1,para2);
        return b;
    }


}
