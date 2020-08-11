/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;
import neu.edu.csye6200.model.Teacher;
/**
 *
 * @author hasee
 */
public class TeacherFactory{

    private static TeacherFactory tf = null;

    private TeacherFactory() {
        super();
    }
    public static TeacherFactory getinstance() {
        if (tf == null) {
            tf = new TeacherFactory();
        }
        return tf;
    }

  
    public Teacher getObject() {
        return new Teacher();
    }

}
