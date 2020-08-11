/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author hasee
 */

public class csvUtil {

    //public static <T> String exportCsv(String[] titles,String[] propertys,List<T> list) throws IOException, IllegalArgumentException, IllegalAccessException{
    public  <T> String exportCsv(String[] head, Object[][] data,String filename) throws IOException, IllegalArgumentException, IllegalAccessException {
        
        File file = new File("C:\\Users\\92967\\Desktop\\"+filename+".csv");
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "gbk");
        
        //String[] titles = new String[]{"Id", "name", "grade"};
        for (String title : head) {
            ow.write(title);
            ow.write(",");
        }
        ow.write("\r\n");
        
        //写内容
//        for (Student s : list) {
//            ow.write(String.valueOf(s.getId()));
//            ow.write(",");
//            ow.write(s.getName());
//            ow.write(",");
//            ow.write(String.valueOf(s.getGrade()));
//            ow.write(",");
//            ow.write("\r\n");
//        }
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                ow.write(String.valueOf(data[i][j]));
                ow.write(",");
            }
            ow.write("\r\n");
        }
        ow.flush();
        ow.close();
        return "0";
    }

}
