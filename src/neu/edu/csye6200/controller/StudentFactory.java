/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;
import neu.edu.csye6200.model.Student;
/**
 *
 * @author hasee
 */
public class StudentFactory{
    private static StudentFactory sf = null;

    private StudentFactory() {
        super();
    }

    public static StudentFactory getinstance() {
        if (sf == null) {
            sf = new StudentFactory();
        }
        return sf;
    }
 
    public Student getObject() {
        return new Student();
    }
    
}
