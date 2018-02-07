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
public class Staff {
    private long id_staff;
    private String s_name;
    private String address;
    private String tel;
    private String s_position;
    private String sex;
    private long id_location;

    public Staff(long id_staff, String s_name, String address, String tel, String s_position, String sex, long id_location) {
        this.id_staff = id_staff;
        this.s_name = s_name;
        this.address = address;
        this.tel = tel;
        this.s_position = s_position;
        this.sex = sex;
        this.id_location = id_location;
    }

    public Staff() {
    }

    public long getId_staff() {
        return id_staff;
    }

    public void setId_staff(long id_staff) {
        this.id_staff = id_staff;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getS_position() {
        return s_position;
    }

    public void setS_position(String s_position) {
        this.s_position = s_position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getId_location() {
        return id_location;
    }

    public void setId_location(long id_location) {
        this.id_location = id_location;
    }
    
    
}
