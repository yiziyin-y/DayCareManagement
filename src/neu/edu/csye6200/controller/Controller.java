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
import neu.edu.csye6200.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author hasee
 */
public class Controller {

    public static Controller ctrlr;
    Connection conn = null;
    PreparedStatement psmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    private List<ClassroomImpl> classroomList;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private GroupFactory gf;
    private ClassroomFactory cf;
    private StudentFactory sf;

    private Controller() {
        this.classroomList = new Vector<>();
        this.studentList = new Vector<>();
        this.teacherList = new Vector<>();
        this.gf = GroupFactory.getinstance();
        this.cf = ClassroomFactory.getInstance();
        this.sf = StudentFactory.getinstance();
    }

    public static Controller GetInstance() {
        if (ctrlr == null) {
            ctrlr = new Controller();
        }
        return ctrlr;
    }

    public void clear() {
        classroomList.clear();
        studentList.clear();
    }

    public int count() {
        return studentList.size();
    }

    public void update() {
        clear();
        String sql = "select * from student";
        conn = mysqlConnecter.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("ID"));
                s.setName(rs.getString("Name"));
                s.setGrade(rs.getInt("Grade"));
                s.setAge(rs.getInt("Age"));
                s.setRegistryDate(rs.getString("RegistryDate"));
                s.setRenewDate(rs.getString("RenewDate"));
                s.setFatherName(rs.getString("FName"));
                s.setMotherName(rs.getString("MName"));
                s.setAddress(rs.getString("Address"));
                s.setPhoneNumber(rs.getInt("Phone"));
                assign(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            mysqlConnecter.closeResource(conn, psmt, stmt, rs);
        }
    }

    public void assign(Student s) {
        if (classroomList.isEmpty()) {
            classroomList.add(ClassroomFactory.getInstance().getObject(classroomList.size() + 1));
            classroomList.get(0).add(s);
            studentList.add(s);
            return;
        }
        for (ClassroomImpl cr : classroomList) {
            if (cr.isSuitFor(s)) {
                cr.add(s);
                studentList.add(s);
                return;
            }
        }
        classroomList.add(ClassroomFactory.getInstance().getObject(classroomList.size() + 1));
        this.assign(s);
    }

    public Object[][] studentData() {
        Object[][] data = new Object[studentList.size()][5];
        int i = 0;
        int prec = 0;
        int preg = 0;
        for (Classroom c : classroomList) {
            for (Group g : c.getGroupList()) {
                for (Student s : g.getStudentList()) {
                //    if(c.getClassroomId() != prec){
                        data[i][0] = c.getClassroomId();
                //        prec = c.getClassroomId();
                //    }
                //    if(g.getGroupId() != preg){
                        data[i][1] = g.getGroupId();
                //        preg = g.getGroupId();
                //    }
                    data[i][2] = s.getStudentId();
                    data[i][3] = s.getName();
                    data[i][4] = s.getAge();
                    i++;
                }
            }
        }
        return data;
    }

}
