/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;

import neu.edu.csye6200.model.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import neu.edu.csye6200.Interface.RecordAPI;
import neu.edu.csye6200.model.Student;

/**
 *
 * @author 92967
 */
public class RecordImpl implements RecordAPI {

    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void insertRec(Record rec) {
        // TODO Auto-generated method stub
        int count = 0;

        String sql = "insert into record values('" + rec.getId() + "','" + rec.getName() + "" + "','" + rec.getage() + "','"
                + "" + rec.getHepB() + "','" + rec.getHepBDate() + "','"
                + "" + rec.getRV() + "','" + rec.getRVDate() + "','"
                + "" + rec.getDTaP() + "','" + rec.getDTaPDate() + "','"
                + "" + rec.getHib() + "','" + rec.getHibDate() + "','"
                + "" + rec.getPCV13() + "','" + rec.getPCV13Date() + "','"
                + "" + rec.getIPV() + "','" + rec.getIPVDate() + "','"
                + "" + rec.getIIV() + "','" + rec.getIIVDate() 
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
        String sql = "delete from record where ID=" + ID;
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

    public Vector ShowRecord() {
        Vector list = new Vector();
        String sql = "select * from record";
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Record r = new Record();
                r.setId(rs.getInt("ID"));
                r.setName(rs.getString("Name"));
                r.setage(rs.getInt("Age"));
                r.setHepB(rs.getInt("HepB"));
                r.setRV(rs.getInt("RV"));
                r.setDTaP(rs.getInt("DTaP"));
                r.setHib(rs.getInt("Hib"));
                r.setPCV13(rs.getInt("PCV13"));
                r.setIPV(rs.getInt("IPV"));
                r.setIIV(rs.getInt("IIV"));
                r.setHepBDate(rs.getString("HepBDate"));
                r.setRVDate(rs.getString("RVDate"));
                r.setDTaPDate(rs.getString("DTaPDate"));
                r.setHibDate(rs.getString("HibDate"));
                r.setPCV13Date(rs.getString("PCV13Date"));
                r.setIPVDate(rs.getString("IPVDate"));
                r.setIIVDate(rs.getString("IIVDate"));

                list.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            mysqlConnecter.closeResource(conn, psmt, stmt, rs);
        }
        return list;

    }
    
    public List<Record> search(int ID){
        List<Record> list = new ArrayList();
        String sql = "select * from record where id=" + ID;
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Record r = new Record();
                r.setId(rs.getInt("ID"));
                r.setName(rs.getString("Name"));
                r.setage(rs.getInt("Age"));
                r.setHepB(rs.getInt("HepB"));
                r.setRV(rs.getInt("RV"));
                r.setDTaP(rs.getInt("DTaP"));
                r.setHib(rs.getInt("Hib"));
                r.setPCV13(rs.getInt("PCV13"));
                r.setIPV(rs.getInt("IPV"));
                r.setIIV(rs.getInt("IIV"));
                r.setHepBDate(rs.getString("HepBDate"));
                r.setRVDate(rs.getString("RVDate"));
                r.setDTaPDate(rs.getString("DTaPDate"));
                r.setHibDate(rs.getString("HibDate"));
                r.setPCV13Date(rs.getString("PCV13Date"));
                r.setIPVDate(rs.getString("IPVDate"));
                r.setIIVDate(rs.getString("IIVDate"));

                list.add(r);
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
