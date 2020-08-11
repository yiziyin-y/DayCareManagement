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
public interface GroupAPI {
       public boolean isSuitFor(Student s) ;
       public boolean isFull() ;
       public void add(Student s);
       public void show();
         
  
}
