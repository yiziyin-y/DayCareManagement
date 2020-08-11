/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import neu.edu.csye6200.Interface.StudentAPI;
import neu.edu.csye6200.model.*;

/**
 *
 * @author 92967
 */
public class StudentImpl implements StudentAPI{
      Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    
       public void insertStu(Student s) {
        // TODO Auto-generated method stub
        int count = 0;

        String sql = "insert into student values('" + s.getId() + "','" + s.getName() + "" + "','" 
                + s.getGrade() + "','"  + "" + s.getAge() + "','"
                + "" + s.getRegistryDate() + "','" +s.getRenewDate() + "','"
                + "" + s.getFatherName()+ "','" + s.getMotherName() + "','"
                + "" + s.getAddress() + "','" +s.getPhoneNumber() 
                + "');";

        System.out.println(sql);
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            mysqlConnecter.closeResource(conn, psmt, stmt, rs);
        }

    }

    public void delete(int ID) {
        // TODO Auto-generated method stub
        int count = 0;
        System.out.println(ID);
        String sql = "delete from student where ID=" + ID;
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            mysqlConnecter.closeResource(conn, psmt, stmt, rs);
        }

    }
    
}
