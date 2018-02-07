/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theprison.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Jamemez
 */
public class Detail_Prisoner {
    private long id_prisoner;
    private String id_card;
    private String name_prisoner;
    private int age;
    private String address;
    private boolean ministry_status;
    private long pri_incrime_id;
    private Date indate;
    private Date outDate;
    private long id_penalty;
    private String penalty;
    private String penalty_detail;
    private String crime;
    private String crime_detail;
    private long id_status;

    public long getId_prisoner() {
        return id_prisoner;
    }

    public void setId_prisoner(long id_prisoner) {
        this.id_prisoner = id_prisoner;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
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

    public long getPri_incrime_id() {
        return pri_incrime_id;
    }

    public void setPri_incrime_id(long pri_incrime_id) {
        this.pri_incrime_id = pri_incrime_id;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public long getId_penalty() {
        return id_penalty;
    }

    public void setId_penalty(long id_penalty) {
        this.id_penalty = id_penalty;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public String getPenalty_detail() {
        return penalty_detail;
    }

    public void setPenalty_detail(String penalty_detail) {
        this.penalty_detail = penalty_detail;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getCrime_detail() {
        return crime_detail;
    }

    public void setCrime_detail(String crime_detail) {
        this.crime_detail = crime_detail;
    }

    public long getId_status() {
        return id_status;
    }

    public void setId_status(long id_status) {
        this.id_status = id_status;
    }

  
    
    public long getCrime_id(){
        long crime_id = 0;
        
         try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("select * from app.crime where id_crime = (select id_crime from app.penalty where id_penalty = ?)");
                
                pstm.setLong(1, this.id_penalty);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                   crime_id = rs.getLong("id_crime");
                   this.setCrime(rs.getString("crime_name"));
                   this.setCrime_detail(rs.getString("crime_descrip"));
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
         
         return crime_id;
    }
    
 
     public void getPenaltyByIdPri(){
 
        try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("select * from app.prisoner_incrime pi join app.penalty p on p.id_penalty = pi.id_penalty where pi.id_prisoner = ? ");
                
                pstm.setLong(1, this.id_prisoner);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    this.setPenalty(rs.getString("punish_name"));  
                    this.setPenalty_detail(rs.getString("punish_detail"));
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
    }
     
     public void getCrimeByIdPenalty(){
 
        try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("select * from APP.crime c where exists (select * from APP.penalty where id_penalty = ? and id_crime = c.id_crime)");
                
                pstm.setLong(1, this.id_penalty);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    this.setCrime(rs.getString("crime_name"));
                    this.setCrime_detail(rs.getString("crime_detail"));
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
    }
    
        public void getObDetailById(long id){
          
            Detail_Prisoner de_pri = null;
            try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("select * from APP.prisoner_incrime pi left join APP.prisoner pr on pi.id_prisoner = pr.id_prisoner where pi.id_prisoner = ?");
                pstm.setLong(1, id);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    de_pri = new Detail_Prisoner();
//                    JOptionPane.showMessageDialog(null,String.valueOf(rs.getLong("id_prisoner")));
                    this.setPri_incrime_id(rs.getLong("id_incrime"));
                    this.setId_prisoner(rs.getLong("id_prisoner"));
                    this.setId_penalty(rs.getLong("id_penalty"));
                    this.setId_status(rs.getLong("id_status"));
                    this.setAge(rs.getInt("age"));
                    this.setIndate(rs.getDate("registerdate"));
                    this.setOutDate(rs.getDate("releasedate"));
                    this.setName_prisoner(rs.getString("name"));
                    this.setId_card(rs.getString("id_card"));
                    this.setMinistry_status(rs.getBoolean("militarystatus"));
                    this.getCrimeByIdPenalty();
                    this.getPenaltyByIdPri();
                           
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
  
        }
    
}
