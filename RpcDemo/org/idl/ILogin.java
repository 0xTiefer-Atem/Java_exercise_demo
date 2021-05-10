package org.idl;

import org.framework.IDoSth;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public abstract class ILogin extends IDoSth {
    public abstract  boolean login(String user,String pass);
}
