/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.model;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author hasee
 */
public class Group {

    private int groupId; 
    private int capacity = 0;
    private List<Student> studentList;
    
    public Group() {
        this.studentList = new Vector<>();
    }
    
    public Group(int id) {
        this.groupId = id; 
        this.studentList = new Vector<>();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
