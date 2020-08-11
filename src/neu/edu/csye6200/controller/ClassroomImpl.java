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
public class ClassroomImpl extends Classroom{

    public ClassroomImpl(int id) {
        super(id);
    }

    public ClassroomImpl() {
        super();
    }
    
    public boolean isSuitFor(Student s){
        if(getGroupList().isEmpty()){
            return true;
        }
        if(s.getAge() >= 6 && s.getAge() <= 47 && getCapacity() == 2){
                return false;
            }
        if(s.getAge() >= 48&&getCapacity() == 3){
                return false;
            }
        if(getGroupList().size() < getCapacity()){
            return true;
        }
        for(GroupImpl g:getGroupList()){
            if(g.isSuitFor(s)){
                return true;
            }
        }
        return false;
    }
    
    public void add(Student s){
        
        if(getGroupList().isEmpty()){
            if(s.getAge() >= 6 && s.getAge() <= 47){
                setCapacity(3);
            }else if(s.getAge() >= 48){
                setCapacity(0x2);
            }
            getGroupList().add(GroupFactory.getinstance().getObject(getGroupList().size()+1));
            getGroupList().get(0).add(s);
            getStudentList().add(s);
            return;
        }
        for(GroupImpl g:getGroupList()){
            if(g.isSuitFor(s)){
                g.add(s);
                getStudentList().add(s);
                return;
            }
        }
        getGroupList().add(GroupFactory.getinstance().getObject(getGroupList().size()+1));
        this.add(s);
        getStudentList().add(s);
    }
}
