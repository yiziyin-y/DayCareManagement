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
import java.util.Vector;
import neu.edu.csye6200.Interface.RenewalAPI;
import neu.edu.csye6200.model.Student;

/**
 *
 * @author tangxin
 */
public class RenewalImpl implements RenewalAPI{
    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    StudentFactory f = StudentFactory.getinstance();
    
    public void renew(int id, String date){
        int count = 0;
        String sql = "update student set RenewDate = '"+ date + "' where id = " + id ;

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
    
    public Vector showRenewal(){
        Vector list = new Vector();
        String sql = "select * from student";
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student stu = f.getObject();
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
