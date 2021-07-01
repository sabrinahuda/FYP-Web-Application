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
public class Admin implements java.io.Serializable{
    private String admin_id;
    private String admin_name;
    private String admin_pass;
    private String admin_phone;

public Admin(String admin_id,String admin_name, String admin_pass, String admin_phone){
    this.admin_id = admin_id;
    this.admin_name = admin_name;
    this.admin_pass = admin_pass;
    this.admin_phone = admin_phone;
}
public Admin()
{
  
}
    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    @Override
    public String toString() {
        return "Admin{" + "admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_pass=" + admin_pass + ", admin_phone=" + admin_phone + '}';
    }


}
