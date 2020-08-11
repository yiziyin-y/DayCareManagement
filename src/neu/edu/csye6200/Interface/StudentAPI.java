/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.Interface;

import neu.edu.csye6200.model.Student;

/**
 *
 * @author 92967
 */
public interface StudentAPI {
    public void insertStu(Student s);
     public void delete(int ID);
}
