/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;
import neu.edu.csye6200.model.*;
/**
 *
 * @author hasee
 */
public class GroupFactory{

    private static GroupFactory gf = null;

    private GroupFactory() {
        super();
    }

    public static GroupFactory getinstance() {
        if (gf == null) {
            gf = new GroupFactory();
        }
        return gf;
    }


    public GroupImpl getObject(int id) {
        return new GroupImpl(id);
    }
    
    public GroupImpl getObject() {
        return new GroupImpl();
    }

}
