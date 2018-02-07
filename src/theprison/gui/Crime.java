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
public class Crime {
    private long id_crime;
    private String crime_name;
    private String crime_descrip;

    public Crime(long id_crime, String crime_name, String crime_descrip) {
        this.id_crime = id_crime;
        this.crime_name = crime_name;
        this.crime_descrip = crime_descrip;
    }

    public Crime() {
    }


    public long getId_crime() {
        return id_crime;
    }

    public void setId_crime(long id_crime) {
        this.id_crime = id_crime;
    }

    public String getCrime_name() {
        return crime_name;
    }

    public void setCrime_name(String crime_name) {
        this.crime_name = crime_name;
    }

    public String getCrime_descrip() {
        return crime_descrip;
    }

    public void setCrime_descrip(String crime_descrip) {
        this.crime_descrip = crime_descrip;
    }
    
    
}
