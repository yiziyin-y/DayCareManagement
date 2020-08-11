/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;

import neu.edu.csye6200.model.Alert;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;
import neu.edu.csye6200.Interface.AlertAPI;


/**
 *
 * @author 92967
 */
public class AlertImpl implements AlertAPI{

    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Vector Alert() {
        Vector list = new Vector();

        String sqlHepB = "select name,id,HepB,HepBDate,age from record where"
                + " HepB = 0 OR (HepB = 1 AND age<=2) OR (HepB = 2 AND age <= 18 AND age>=6)";

        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlHepB);
            while (rs.next()) {

                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("HepB");
                a.setDoze(rs.getInt("HepB"));
                if (rs.getInt("HepB") != 0) {
                    a.setDate(rs.getDate("HepBDate"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sqlRV = "select name,id,RV,RVDate,age from record where"
                + " (RV = 0 AND age<=2 AND age>=1) OR (RV = 1 AND age<=4 AND age>2)";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlRV);
            while (rs.next()) {
                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("RV");
                a.setDoze(rs.getInt("RV"));
                if (rs.getInt("RV") != 0) {
                    a.setDate(rs.getDate("RVDate"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sqldtap = "select name,id,DTaP,DTaPDate,age from record where"
                + "(DTaP= 0 AND age<=2 AND age>=1) OR (DTaP = 1 AND age<=4 AND age>2)"
                + "OR (DTaP = 2 AND age<=6 AND age>4) OR (DTaP = 3 AND age<=18 AND age>=15)"
                + "OR (DTaP = 4 AND age<=72 AND age>48)";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqldtap);
            while (rs.next()) {
                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("DTaP");
                a.setDoze(rs.getInt("DTaP"));
                if (rs.getInt("DTaP") != 0) {
                    a.setDate(rs.getDate("DTaPDate"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sqlhib = "select name,id,hib,hibDate,age from record where"
                + "(hib= 0 AND age<=2 AND age>=1) OR (hib = 1 AND age<=4 AND age>2)"
                + "OR (hib = 2 AND age<=6 AND age>4) OR (hib = 3 AND age<=15 AND age>=12)";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlhib);
            while (rs.next()) {
                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("Hib");
                a.setDoze(rs.getInt("Hib"));
                if (rs.getInt("Hib") != 0) {
                    a.setDate(rs.getDate("HibDate"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sqlpcv13 = "select name,id,pcv13,pcv13Date,age from record where"
                + "(pcv13= 0 AND age<=2 AND age>=1) OR (pcv13 = 1 AND age<=4 AND age>2)"
                + "OR (pcv13 = 2 AND age<=6 AND age>4) OR (pcv13 = 3 AND age<=15 AND age>=12)";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlpcv13);
            while (rs.next()) {
                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("PCV13");
                a.setDoze(rs.getInt("PCV13"));
                if (rs.getInt("PCV13") != 0) {
                    a.setDate(rs.getDate("PCV13Date"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sqlIPV = "select name,id,IPV,IPVDate,age from record where"
                + "(IPV= 0 AND age<=2 AND age>=1) OR (IPV = 1 AND age<=4 AND age>2)"
                + "OR (IPV = 2 AND age<=18 AND age>6) OR (IPV = 3 AND age<=72 AND age>=48)";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlIPV);
            while (rs.next()) {
                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("IPV");
                a.setDoze(rs.getInt("IPV"));
                if (rs.getInt("IPV") != 0) {
                    a.setDate(rs.getDate("IPVDate"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sqlIIV = "select name,id,IIV,IIVDate,age from record where"
                + "(IIV= 0 AND age<=12 AND age>=6) OR (IIV = 1 AND age<=24 AND age>12)"
                + "OR (IIV = 2 AND age<=36 AND age>24) OR (IIV = 3 AND age<=48 AND age>36)"
                + "OR (IIV = 4 AND age<=60 AND age>48) OR (IIV = 5 AND age<=72 AND age>60)";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlIIV);
            while (rs.next()) {
                Alert a = new Alert();
                a.setId(rs.getInt("ID"));
                a.setName(rs.getString("Name"));
                a.setAge(rs.getInt("age"));
                a.setType("IIV");
                a.setDoze(rs.getInt("IIV"));
                if (rs.getInt("IIV") != 0) {
                    a.setDate(rs.getDate("IIVDate"));
                }
                list.add(a);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;

    }

    public static void main(String[] args) {
        AlertImpl ai = new AlertImpl();
        Vector list = ai.Alert();
        for (Object o : list) {

            System.out.println(o);
        }

    }
}
