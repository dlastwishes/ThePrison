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
public class Prisoner {
    private long id_prisoner;
    private long id_card;
    private String name_prisoner;
    private int age;
    private String address;
    private boolean ministry_status;

    public Prisoner(long id_prisoner, long id_card, String name_prisoner, int age, String address, boolean ministry_status) {
        this.id_prisoner = id_prisoner;
        this.id_card = id_card;
        this.name_prisoner = name_prisoner;
        this.age = age;
        this.address = address;
        this.ministry_status = ministry_status;
    }

    public Prisoner() {
    }

    public long getId_prisoner() {
        return id_prisoner;
    }

    public void setId_prisoner(long id_prisoner) {
        this.id_prisoner = id_prisoner;
    }

    public long getId_card() {
        return id_card;
    }

    public void setId_card(long id_card) {
        this.id_card = id_card;
    }

    public String getName_prisoner() {
        return name_prisoner;
    }

    public void setName_prisoner(String name_prisoner) {
        this.name_prisoner = name_prisoner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMinistry_status() {
        return ministry_status;
    }

    public void setMinistry_status(boolean ministry_status) {
        this.ministry_status = ministry_status;
    }
    
    
}
