/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theprison.gui;

/**
 *
 * @author Jamemez
 */
public class Warden {
    private long id_warden;
    private String name_warden;
    private String w_position;
    private String education;
    private long id_lcation;

    public Warden(long id_warden, String name_warden, String w_position, String education) {
        this.id_warden = id_warden;
        this.name_warden = name_warden;
        this.w_position = w_position;
        this.education = education;
    }

    public Warden() {
    }

    public long getId_warden() {
        return id_warden;
    }

    public void setId_warden(long id_warden) {
        this.id_warden = id_warden;
    }

    public String getName_warden() {
        return name_warden;
    }

    public void setName_warden(String name_warden) {
        this.name_warden = name_warden;
    }

    public String getW_position() {
        return w_position;
    }

    public void setW_position(String w_position) {
        this.w_position = w_position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public long getId_lcation() {
        return id_lcation;
    }

    public void setId_lcation(long id_lcation) {
        this.id_lcation = id_lcation;
    }
    
    
    
    
}
