/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ADMIN
 */
public class Student implements java.io.Serializable{
    private String stud_id;
    private String stud_Name;
    private String stud_Email;
    private String stud_phone;
    

    public Student(String stud_id, String stud_Name, String stud_Email, String stud_phone) {
        this.stud_id = stud_id;
        this.stud_Name = stud_Name;
        this.stud_Email = stud_Email;
        this.stud_phone = stud_phone;
    }
    
    public Student(){
        
    }

    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_Name() {
        return stud_Name;
    }

    public void setStud_Name(String stud_Name) {
        this.stud_Name = stud_Name;
    }

    public String getStud_Email() {
        return stud_Email;
    }

    public void setStud_Email(String stud_Email) {
        this.stud_Email = stud_Email;
    }

    public String getStud_phone() {
        return stud_phone;
    }

    public void setStud_phone(String stud_phone) {
        this.stud_phone = stud_phone;
    }

    @Override
    public String toString() {
        return "Student{" + "stud_id=" + stud_id + ", stud_Name=" + stud_Name + ", stud_Email=" + stud_Email + ", stud_phone=" + stud_phone + '}';
    }
    
    
    
    
}
