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
import neu.edu.csye6200.Interface.RegistryAPI;
import neu.edu.csye6200.model.Student;

/**
 *
 * @author tangxin
 */
public class RegistryImpl implements RegistryAPI{
    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    StudentFactory f = StudentFactory.getinstance();
    
    public Vector showRegistry(){
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
                stu.setRegistryDate(rs.getString("RegistryDate"));
                stu.setRenewDate(rs.getString("RenewDate"));

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
