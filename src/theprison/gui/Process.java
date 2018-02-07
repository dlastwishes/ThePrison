/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theprison.gui;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamemez
 */
public class Process {
    static long crime_id;
    
    public static void addPenalty(long id, String crime_name,String crime_descrip){
         try{
            String sql = "insert into APP.penalty(punish_name,punish_detail,id_crime) values(?,?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, crime_name);
            pstm.setString(2, crime_descrip);
            pstm.setLong(3,id);
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void addCrime(String crime_name,String cri_descrip){
         try{
            String sql = "insert into APP.crime(crime_name,crime_detail) values(?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, crime_name);
            pstm.setString(2, cri_descrip);
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<Crime> getCrimeList(){
        ArrayList<Crime> crimes = new ArrayList();
        Crime crime = null;
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.crime");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                crime = new Crime();
                crime.setId_crime(rs.getLong("id_crime"));
                crime.setCrime_name(rs.getString("crime_name"));
                crime.setCrime_descrip(rs.getString("crime_detail"));
                crimes.add(crime);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return crimes;
    }
    
        
    public static ArrayList<Status> getStatusList(){
        ArrayList<Status> statuss = new ArrayList();
        Status status = null;
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.status");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                status = new Status();
                status.setId_status(rs.getLong("id_status"));
                status.setStatus_name(rs.getString("status_name"));
                status.setStatus_descrip(rs.getString("status_detail"));
                statuss.add(status);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return statuss;
    }
        
    public static String getStatusByIdPri(long id){
        String status = "";
        try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("select status_name from APP.status where id_status in (select id_status from APP.prisoner_incrime where id_prisoner = ?)");
                
                pstm.setLong(1, id);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    status = rs.getString("status_name");  
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        return status;
    }
    
    
        
        public static void AddPrisonerInCrime(Date in , Date out , long id_pri , long id_penal,long id_stat,long id_person)
        {
            try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("insert into APP.prisoner_incrime(registerdate,releasedate,id_prisoner,id_penalty,id_status,id_prison)"
                        + "values(?,?,?,?,?,?)");
                pstm.setDate(1, new java.sql.Date(in.getTime()));
                pstm.setDate(2, new java.sql.Date(out.getTime()));
                pstm.setLong(3, id_pri);
                pstm.setLong(4, id_penal);
                pstm.setLong(5, id_stat);
                pstm.setLong(6, id_person);
                pstm.executeUpdate();
                        
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        public ArrayList<Prisoner> searchPrisonerByCrimeId(long id_crime){
            ArrayList<Prisoner> prisoners = null;
            Prisoner pri = null;
            try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("select * from app.prisoner where id_prisoner in (select id_prisoner from app.prisoner_incrime where id_penalty in (select id_penalty from app.penalty where id_crime = ?))");
                pstm.setLong(1, id_crime);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    pri = new Prisoner();
                    orm_prisoner(rs,pri);
                    if(prisoners == null){
                        prisoners = new ArrayList();
                    }
                    prisoners.add(pri);
                }
            }   
            catch(Exception ex){
                ex.printStackTrace();
            }
            return prisoners;
            
        }
        
        
        public static ArrayList<Penalty> getPenaltyList(){
        ArrayList<Penalty> penaltys = new ArrayList();
        Penalty penalty = null;
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.penalty");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                penalty = new Penalty();
                penalty.setId_penalty(rs.getLong("id_penalty"));
                penalty.setPunish_name(rs.getString("punish_name"));
                penalty.setPunish_detail(rs.getString("punish_detail"));
                penalty.setId_crime(rs.getLong("id_crime"));
                penaltys.add(penalty);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return penaltys;
    }
    
    public static void getIdCrimeByName(String name){
        Crime crime = new Crime();
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.crime where lower(crime_name) = ?");
            pstm.setString(1, name.toLowerCase());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                crime_id = rs.getLong("id_crime");
 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
    
    public void insertLocation(long prison_id,String location_name,String loca_descrip){
         try{
            String sql = "insert into APP.location_prison(location_name,location_detail,id_prison) values(?,?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, location_name);
            pstm.setString(2, loca_descrip);
            pstm.setLong(3,prison_id);
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void newPrisoner(String id_card,String name,String age,String address,boolean ministry){
         try{
            String sql = "insert into APP.prisoner(id_card,name,age,address,militarystatus) values(?,?,?,?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,id_card);
            pstm.setString(2, name);
            pstm.setString(3,age);
            pstm.setString(4, address);
            pstm.setBoolean(5, ministry);
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     public void newStaff(String name , String add , String tel , String position , String sex , long id_location){
         try{
            String sql = "insert into APP.staff(name,address,telno,position,sex,id_location) values(?,?,?,?,?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setString(1, name);
           pstm.setString(2, add);
           pstm.setString(3,tel);
           pstm.setString(4,position);
           pstm.setString(5, sex);
           pstm.setLong(6, id_location);
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
     
     public Prisoner searchPrisonerByIdCard(long pri_id){
         Prisoner pri = new Prisoner();
         try{
             String sql = "select p.* from APP.prisoner p left join APP.prisoner_incrime pi on p.id_prisoner = pi.id_prisoner where p.id_card = ?";
             Connection conn = Connectionbuilder.connect();
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setLong(1, pri_id);
             ResultSet rs = pstm.executeQuery();
             if(rs.next()){
               
               orm_prisoner(rs,pri);
             }
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
         return pri;
     }
     
     public ArrayList<Prisoner> searchPrisonerByName(String name){
         ArrayList<Prisoner> prisoners = null;
         Prisoner pri = null;
         try{
             String sql = "select p.* from APP.prisoner p left join APP.prisoner_incrime pi on p.id_prisoner = pi.id_prisoner where lower(name) like ?";
             Connection conn = Connectionbuilder.connect();
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setString(1, "%"+name.toLowerCase()+"%");
             ResultSet rs = pstm.executeQuery();
             while(rs.next()){
                 pri =new Prisoner();
               orm_prisoner(rs,pri);
               if(prisoners==null){
                   prisoners = new ArrayList();
               }
               prisoners.add(pri);
             }
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
         return prisoners;
     }
   
     
     public void newWarden(String name , String position , String education, long id_location){
         try{
            String sql = "insert into APP.warden(name,position,education,id_location) values(?,?,?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, position);
            pstm.setString(3, education);
            pstm.setLong(4, id_location);
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void insertGoodHis(long prisoner_id,String good_detail,Date good_date){
         try{
            String sql = "insert into APP.good_history(activity_detail,id_prisoner,activity_date) values(?,?,?)";
            
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, good_detail);
            pstm.setLong(2, prisoner_id);
            pstm.setDate(3, new java.sql.Date(good_date.getTime()));
            pstm.executeUpdate();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    public long getPrisonID(long sid){
          long prisonId = 0;
        try{
            String sql = "select * from APP.staff s left join APP.locationprison lp on s.id_location = lp.id_location"
                    + " left join APP.prison p on p.id_prison = lp.id_prison where s.id_staff = ?";
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, sid);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                  prisonId = rs.getLong("id_prison");
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return prisonId;
    }
    
    public Staff checkOwner(long sid){
        Staff staff = null;
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.staff where id_staff = "+sid);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                        staff = new Staff();
                        orm_staff(rs,staff);
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return staff;
    }
            
    
    public boolean submitVisitor(long sid, String visitor,int idcard ,Date date,long pri_id){
         boolean confirm = false;
            try{
                Connection conn = Connectionbuilder.connect();
                PreparedStatement pstm = conn.prepareStatement("insert into APP.history_visit(visitor_name , visitor_idcard,visit_date,id_staff,id_prisoner)"
                        + " values (?,?,?,?,?)");
                pstm.setString(1,visitor);
                pstm.setInt(2, idcard);
                pstm.setDate(3, new java.sql.Date(date.getTime()));
                pstm.setLong(4, sid);
                pstm.setLong(5, pri_id);
                pstm.executeUpdate();
            }
         catch(Exception ex){
             ex.printStackTrace();
         }
         
        return confirm;
    }
            
    public static boolean checkLogin(String username , String password){
        boolean cLogin = false;
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.security");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
              
                if(rs.getString("username").equalsIgnoreCase(username)){
                  
                    if(rs.getString("password").equalsIgnoreCase(password)){
                        cLogin = true;
                    }
                }
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         return cLogin;
        
    }
    public static long getId(String username , String password){
        long staffId = 0;
        try{
            Connection conn = Connectionbuilder.connect();
            PreparedStatement pstm = conn.prepareStatement("select * from APP.security");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
              
                if(rs.getString("username").equalsIgnoreCase(username)){
                  
                    if(rs.getString("password").equalsIgnoreCase(password)){
                        staffId = rs.getLong("id_staff");
                    }
                }
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         return staffId;
        
    }
    public ArrayList<Staff> getSearchStaff(String keyword){
        ArrayList<Staff> staffs = null;
        Staff staff = null;
        String sql = "";
        try{
             Connection conn = Connectionbuilder.connect();
          sql = "select * from APP.staff where (lower(name) like ?) OR (lower(address) like ?) or (lower(position) like ?) or (lower(sex) like ?)";
                PreparedStatement pstm1 = conn.prepareStatement(sql);
                pstm1.setString(1,"%"+keyword.toLowerCase()+"%");
                pstm1.setString(2,"%"+keyword.toLowerCase()+"%");
                pstm1.setString(3,"%"+keyword.toLowerCase()+"%");
                pstm1.setString(4,"%"+keyword.toLowerCase()+"%");
                ResultSet rs = pstm1.executeQuery();
                 while(rs.next()){
                     staff = new Staff();
                     orm_staff(rs,staff);
                     if(staffs == null){
                         staffs = new ArrayList();
                     }
                     staffs.add(staff);
                     
                 }
        }
        catch(Exception ex){
        ex.printStackTrace();
        
        }
        
       
                 return staffs;
    }
    
    public ArrayList<Warden> getSearchWarden(String keyword){
        ArrayList<Warden> wardens = null;
        Warden warden = null;
        String sql = "";
        try{
            Connection conn = Connectionbuilder.connect();
           
                sql = "select * from APP.warden where lower(name) like ? or lower(position) like ? or lower(education) like ?";
                 PreparedStatement pstm = conn.prepareStatement(sql);
                 pstm.setString(1, "%"+keyword.toLowerCase()+"%");
                 pstm.setString(2, "%"+keyword.toLowerCase()+"%");
                 pstm.setString(3,"%"+keyword.toLowerCase()+"%");
                 ResultSet rs = pstm.executeQuery();
                 while(rs.next()){
                     warden = new Warden();
                     orm_warden(rs,warden);
                     if(wardens == null){
                         wardens = new ArrayList();
                     }
                     wardens.add(warden);
                     
                 }
                 
            }
           
        catch(Exception ex){
            ex.printStackTrace();
        }
     return wardens;
    }
    
    private void orm_warden(ResultSet rs , Warden war) throws SQLException{
        war.setId_warden(rs.getLong("id_warden"));
        war.setName_warden(rs.getString("name"));
        war.setW_position(rs.getString("position"));
        war.setEducation(rs.getString("education"));
        war.setId_lcation(rs.getLong("id_location"));
    }
    
    private void orm_staff(ResultSet rs , Staff staff) throws SQLException{
        staff.setId_staff(rs.getLong("id_staff"));
        staff.setS_name(rs.getString("name"));
        staff.setAddress(rs.getString("address"));
        staff.setTel(rs.getString("telno"));
        staff.setS_position(rs.getString("position"));
        staff.setSex(rs.getString("sex"));
        staff.setId_location(rs.getLong("id_location"));
        
    }
    private void orm_prisoner(ResultSet rs , Prisoner pri) throws SQLException{
        pri.setId_prisoner(rs.getLong("id_prisoner"));
        pri.setId_card(Long.decode(rs.getString("id_card")));
        pri.setName_prisoner(rs.getString("name"));
        pri.setAge(rs.getInt("age"));
        pri.setAddress(rs.getString("address"));
        pri.setMinistry_status(rs.getBoolean("militarystatus"));
        
    }
}
