/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.model;

import java.util.Date;
import neu.edu.csye6200.model.AbstractPerson;

/**
 *
 * @author hasee
 */
public class Teacher extends AbstractPerson {
    private int credits;
    private int teacherId;
    private String reviewDate;
    
    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Teacher{" + "credits=" + credits + ", teacherId=" + teacherId + '}';
    }
    
}
