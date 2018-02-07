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
public class Penalty {
    private long id_penalty;
    private String punish_name;
    private String punish_detail;
    private long id_crime;

    public Penalty(long id_penalty, String punish_name, String punish_detail, long id_crime) {
        this.id_penalty = id_penalty;
        this.punish_name = punish_name;
        this.punish_detail = punish_detail;
        this.id_crime = id_crime;
    }

    public Penalty() {
    }

    public long getId_penalty() {
        return id_penalty;
    }

    public void setId_penalty(long id_penalty) {
        this.id_penalty = id_penalty;
    }

    public String getPunish_name() {
        return punish_name;
    }

    public void setPunish_name(String punish_name) {
        this.punish_name = punish_name;
    }

    public String getPunish_detail() {
        return punish_detail;
    }

    public void setPunish_detail(String punish_detail) {
        this.punish_detail = punish_detail;
    }

    public long getId_crime() {
        return id_crime;
    }

    public void setId_crime(long id_crime) {
        this.id_crime = id_crime;
    }
    
    
}
