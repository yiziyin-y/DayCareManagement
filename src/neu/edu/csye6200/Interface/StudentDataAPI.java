/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.Interface;

import java.util.List;
import java.util.Vector;
import neu.edu.csye6200.model.Student;

/**
 *
 * @author tangxin
 */
public interface StudentDataAPI {
    public Vector showStuentData();
    public void delete(int ID);
    public List<Student> search(int ID);
}
