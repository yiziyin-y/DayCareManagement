/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.csye6200.model;

import java.util.Date;

/**
 *
 * @author 92967
 */
public class Alert {

    private int id;
    private int doze;
    private int age;
    private String name;
    private String type;
    private Date date;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    
    

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
     /**
     * @return the doze
     */
    public int getDoze() {
        return doze;
    }

    /**
     * @param doze the doze to set
     */
    public void setDoze(int doze) {
        this.doze = doze;
    }
    
      /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }


    public Alert(int id,int doze, int age, String name, String type, Date date) {
        super();
        this.id = id;
        this.doze = doze;
        this.age = age;
        this.name = name;
        this.type = type;
        this.date = date;
    }

    public Alert() {
      
    }
    	
	@Override
		public String toString() {
			return "[id=" + id + ", doze=" + doze + ", age="+ age + ", name=" + name + ", type=" + type + ", date=" + date + "]";
		}

  

   
}
