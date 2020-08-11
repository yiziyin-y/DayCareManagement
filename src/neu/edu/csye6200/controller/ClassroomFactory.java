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
public class ClassroomFactory{

    private static ClassroomFactory cf = null;

    private ClassroomFactory() {
        super();
    }

    public static ClassroomFactory getInstance() {
        if (cf == null) {
            cf = new ClassroomFactory();
        }
        return cf;
    }

    
    public ClassroomImpl getObject(int id) {
        return new ClassroomImpl(id);
    }
    public ClassroomImpl getObject() {
        return new ClassroomImpl();
    }
    

}
