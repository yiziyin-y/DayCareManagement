/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.Interface;

import java.util.Vector;
import neu.edu.csye6200.model.Teacher;

/**
 *
 * @author tangxin
 */
public interface ReviewAPI {
    public void insertpunish(int id, int score);
    public void delete(int ID);
    public Vector showReview();
}

