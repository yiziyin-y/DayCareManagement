/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.model;

import neu.edu.csye6200.controller.*;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author hasee
 */
public class Classroom {

    private int capacity;
    private int classroomId;
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<GroupImpl> groupList;

    public Classroom() {
        this.capacity = 0;
        this.teacherList = new Vector<>();
        this.studentList = new Vector<>();
        this.groupList = new Vector<>();
    }

    public Classroom(int id) {
        this.capacity = 0;
        this.classroomId = id;
        this.teacherList = new Vector<>();
        this.studentList = new Vector<>();
        this.groupList = new Vector<>();
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<GroupImpl> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupImpl> groupList) {
        this.groupList = groupList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //public abstract boolean isFull();
}
