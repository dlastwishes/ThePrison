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
public class Status {
    private long id_status;
    private String status_name;
    private String status_descrip;

    public Status(long id_status, String status_name, String status_descrip) {
        this.id_status = id_status;
        this.status_name = status_name;
        this.status_descrip = status_descrip;
    }

    public Status(long id_status) {
        this.id_status = id_status;
    }

    Status() {
       

    }

    public long getId_status() {
        return id_status;
    }

    public void setId_status(long id_status) {
        this.id_status = id_status;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getStatus_descrip() {
        return status_descrip;
    }

    public void setStatus_descrip(String status_descrip) {
        this.status_descrip = status_descrip;
    }
    
    
}
