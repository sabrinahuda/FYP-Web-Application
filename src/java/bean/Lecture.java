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
public class Lecture implements java.io.Serializable{
    private String lect_id;
    private String lect_name;
    private String lect_email;
    private String room_no;
    private String status;

    public Lecture(String lect_id, String lect_name, String lect_email, String room_no, String status) {
        this.lect_id = lect_id;
        this.lect_name = lect_name;
        this.lect_email = lect_email;
        this.room_no = room_no;
        this.status = status;
    }
    
    public Lecture(){
        
    }

    public String getLect_id() {
        return lect_id;
    }

    public void setLect_id(String lect_id) {
        this.lect_id = lect_id;
    }

    public String getLect_name() {
        return lect_name;
    }

    public void setLect_name(String lect_name) {
        this.lect_name = lect_name;
    }

    public String getLect_email() {
        return lect_email;
    }

    public void setLect_email(String lect_email) {
        this.lect_email = lect_email;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lecture{" + "lect_id=" + lect_id + ", lect_name=" + lect_name + ", lect_email=" + lect_email + ", room_no=" + room_no + ", status=" + status + '}';
    }
    
    
}
