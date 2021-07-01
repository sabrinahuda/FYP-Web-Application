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
public class Project implements java.io.Serializable{
    
    private String proj_id;
    private String proj_title;
    private String objective;

    public Project(String proj_id, String proj_title, String objective) {
        this.proj_id = proj_id;
        this.proj_title = proj_title;
        this.objective = objective;
    }
    
    public Project ()
    {
        
    }   

    public String getProj_id() {
        return proj_id;
    }

    public void setProj_id(String proj_id) {
        this.proj_id = proj_id;
    }

    public String getProj_title() {
        return proj_title;
    }

    public void setProj_title(String proj_title) {
        this.proj_title = proj_title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    @Override
    public String toString() {
        return "Project{" + "proj_id=" + proj_id + ", proj_title=" + proj_title + ", objective=" + objective + '}';
    }
    
    
}
