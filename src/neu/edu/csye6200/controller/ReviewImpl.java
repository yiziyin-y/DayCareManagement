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
import neu.edu.csye6200.Interface.ReviewAPI;
import neu.edu.csye6200.model.Teacher;

/**
 *
 * @author tangxin
 */
public class ReviewImpl implements ReviewAPI{
    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public void insertpunish(int id, int score){
        int count = 0;
        String sql = "update teacher set credit = " + score + " where id = " + id ;

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
        String sql = "delete from teacher where ID=" + ID;
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
    
    public Vector showReview(){
        Vector list = new Vector();
        String sql = "select * from teacher";
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("ID"));
                t.setName(rs.getString("Name"));
                t.setCredits(rs.getInt("Credit"));
                t.setReviewDate(rs.getString("ReviewDate"));

                list.add(t);
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
