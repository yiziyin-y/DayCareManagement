/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;
import neu.edu.csye6200.model.*;
import neu.edu.csye6200.Interface.GroupAPI;
/**
 *
 * @author hasee
 */
public class GroupImpl extends Group implements GroupAPI{
    
    public GroupImpl() {
        super();
    }
    
    public GroupImpl(int id) {
        super(id);
    }

    public boolean isSuitFor(Student s) {
        if (getStudentList().isEmpty()) {
            return true;
        }
        int age = s.getAge();
        if (age >= 6 && age <= 12) {
            return getCapacity()== 4 && !this.isFull();
        } else if (age >= 13 && age <= 24) {
            return getCapacity() == 5 && !this.isFull();
        } else if (age >= 25 && age <= 35) {
            return getCapacity() == 6 && !this.isFull();
        } else if (age >= 36 && age <= 47) {
            return getCapacity() == 8 && !this.isFull();
        } else if (age >= 48 && age <= 59) {
            return getCapacity() == 12 && !this.isFull();
        } else if (age >= 60) {
            return getCapacity() == 15 && !this.isFull();
        }
        return false;
    }

    public boolean isFull() {
        return getStudentList().size() >= getCapacity();
    }

    public void add(Student s) {
        if (getStudentList().isEmpty()) {
            int age = s.getAge();
            if (age >= 6 && age <= 12) {
                setCapacity(4);
            } else if (age >= 13 && age <= 24) {
                setCapacity(5);
            } else if (age >= 25 && age <= 35) {
                setCapacity(6);
            } else if (age >= 36 && age <= 47) {
                setCapacity(8);
            } else if (age >= 48 && age <= 59) {
                setCapacity(12);
            } else if (age >= 60) {
                setCapacity(15);
            }
        }
        getStudentList().add(s);
    }

    public void show() {
        for (Student student : getStudentList()) {
            System.out.println(student);
        }
    }
}
