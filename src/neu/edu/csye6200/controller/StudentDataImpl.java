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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import neu.edu.csye6200.Interface.StudentDataAPI;
import neu.edu.csye6200.model.Student;

/**
 *
 * @author tangxin
 */
public class StudentDataImpl implements StudentDataAPI{
    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public Vector showStuentData(){
        Vector list = new Vector();
        String sql = "select * from student";
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt("ID"));
                stu.setName(rs.getString("Name"));
                stu.setGrade(rs.getInt("Grade"));
                stu.setAge(rs.getInt("Age"));
                stu.setRegistryDate(rs.getString("RegistryDate"));
                stu.setRenewDate(rs.getString("RenewDate"));
                stu.setFatherName(rs.getString("FName"));
                stu.setMotherName(rs.getString("MName"));
                stu.setAddress(rs.getString("Address"));
                stu.setPhoneNumber(rs.getInt("Phone"));

                list.add(stu);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            mysqlConnecter.closeResource(conn, psmt, stmt, rs);
        }
        return list;
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
    
    public List<Student> search(int ID){
        List<Student> list = new ArrayList();
        String sql = "select * from student where id=" + ID;
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt("ID"));
                stu.setName(rs.getString("Name"));
                stu.setGrade(rs.getInt("Grade"));
                stu.setAge(rs.getInt("Age"));
                stu.setRegistryDate(rs.getString("RegistryDate"));
                stu.setRenewDate(rs.getString("RenewDate"));
                stu.setFatherName(rs.getString("FName"));
                stu.setMotherName(rs.getString("MName"));
                stu.setAddress(rs.getString("Address"));
                stu.setPhoneNumber(rs.getInt("Phone"));

                list.add(stu);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            mysqlConnecter.closeResource(conn, psmt, stmt, rs);
        }
        return list;
       
    }
    
    
    
}
