/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvjce;

import java.sql.*;
import java.util.*;
import java.text.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author narein
 */
public class Database {
    
    static void Select_scheme(String scheme,int screen) {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet detail = st.executeQuery("select * from Scheme where Course_code='"+scheme+"'");
        detail.next();
        if(screen==1){
        internalMarks.l1.setText(detail.getString(2));
        internalMarks.l2.setText(detail.getString(3));
        internalMarks.l3.setText(detail.getString(4));
        internalMarks.l4.setText(detail.getString(5));
        internalMarks.l5.setText(detail.getString(6));
        internalMarks.l6.setText(detail.getString(7));
        internalMarks.l7.setText(detail.getString(8));
        internalMarks.l8.setText(detail.getString(9));
        }
        else{
        attendance.l1.setText(detail.getString(2));
        attendance.l2.setText(detail.getString(3));
        attendance.l3.setText(detail.getString(4));
        attendance.l4.setText(detail.getString(5));
        attendance.l5.setText(detail.getString(6));
        attendance.l6.setText(detail.getString(7));
        attendance.l7.setText(detail.getString(8));
        attendance.l8.setText(detail.getString(9));
        }
        }catch(Exception e){print_error("Select_scheme");}
    }
    
    String sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,internal,name,course,section,sem, sub1_name, sub1_code,sub1_class,sub1_ext;
    String  sub2_name, sub2_code,sub2_class,sub2_ext, sub3_name, sub3_code,sub3_class,sub3_ext, sub4_name, sub4_code,sub4_class,sub4_ext, sub5_name, sub5_code,sub5_class,sub5_ext, sub6_name, sub6_code,sub6_class,sub6_ext, sub7_name, sub7_code,sub7_class,sub7_ext, sub8_name, sub8_code,sub8_class,sub8_ext;
    
    void Insert(String usn,int function){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        switch(function){
            //case 0:st.executeUpdate("insert into internals values ('"+usn+"',0,0,0,0,0,0,0,0,0,0,0,0)");
                   //break;
            case 1:
                st.executeUpdate("UPDATE internals"+
                                 " SET sub1_int"+internal+"="+sub1+", sub2_int"+internal+"="+sub2+", sub3_int"+internal+"="+sub3+", sub4_int"+internal+"="+sub4+" WHERE USN='"+usn+"'");  
                st.executeUpdate("UPDATE internals2"+
                                 " SET sub5_int"+internal+"="+sub5+", sub6_int"+internal+"="+sub6+", sub7_int"+internal+"="+sub7+", sub8_int"+internal+"="+sub8+" WHERE USN='"+usn+"'");
                break;
            case 2:
   
                st.executeUpdate("UPDATE attendance"+
                                 " SET sub1_class ="+sub1+", sub2_class ="+sub2+", sub3_class ="+sub3+", sub4_class ="+sub4+", sub5_class ="+sub5+
                                 ", sub6_class ="+sub6+", sub7_class ="+sub7+", sub8_class ="+sub8+" WHERE USN='"+usn+"'");
                break;
            case 3:
                st.execute("insert into Student_info values('"+usn+"','"+name+"','"+course+"','"+section+"','"+sem+"')");
                st.execute("insert into internals values ('"+usn+"',0,0,0,0,0,0,0,0,0,0,0,0)");st.execute("insert into internals2 values ('"+usn+"',0,0,0,0,0,0,0,0,0,0,0,0)");
                st.execute("insert into attendance values ('"+usn+"',0,0,0,0,0,0,0,0)");
                break;
                /*ResultSet rs = st.executeQuery("select * from internal_year"+year+" where USN='"+usn+"'");
                rs.next();
                s1=rs.getString("sub1_int"+internal);s2=rs.getString("sub2_int"+internal);s3=rs.getString("sub3_int"+internal);
                s4=rs.getString("sub4_int"+internal);s5=rs.getString("sub5_int"+internal);s6=rs.getString("sub6_int"+internal);
                s7=rs.getString("sub7_int"+internal);s8=rs.getString("sub8_int"+internal);
                break;*/
                
        }       
        
        }catch(Exception e){print_error("update");}
    
    }
    /*void rep(String usn, String internal, String scheme)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs1 = st.executeQuery("select * from external e natural join attendance natural join student_info where usn = '"+usn+";");
        ResultSet rs2 = st.executeQuery("select sub1_int"+internal+" as sub1,sub2_int"+internal+" as sub2 ,sub3_int"+internal+" as sub3,sub4_int"+internal+" as sub4,sub5_int"+internal+" as sub5,sub6_int"+internal+" as sub6,sub7_int"+internal+" as sub7,sub8_int"+internal+" as sub8from internals natural join internals2 where usn="+usn+";");
        ResultSet rs3 = st.executeQuery("select * from scheme natural join subject_names where course_code="+scheme+";");
      
        st.execute("truncate result;");
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub1_name)+","+rs3.getString(sub1_code)+","+rs2.getString(sub1)+","+rs1.getString(sub1_class)+",Sub1,"+rs1.getString(sub1_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub2_name)+","+rs3.getString(sub2_code)+","+rs2.getString(sub2)+","+rs1.getString(sub2_class)+",Sub1,"+rs1.getString(sub2_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub3_name)+","+rs3.getString(sub3_code)+","+rs2.getString(sub3)+","+rs1.getString(sub3_class)+",Sub1,"+rs1.getString(sub3_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub4_name)+","+rs3.getString(sub4_code)+","+rs2.getString(sub4)+","+rs1.getString(sub4_class)+",Sub1,"+rs1.getString(sub4_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub5_name)+","+rs3.getString(sub5_code)+","+rs2.getString(sub5)+","+rs1.getString(sub5_class)+",Sub1,"+rs1.getString(sub5_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub6_name)+","+rs3.getString(sub6_code)+","+rs2.getString(sub6)+","+rs1.getString(sub6_class)+",Sub1,"+rs1.getString(sub6_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub7_name)+","+rs3.getString(sub7_code)+","+rs2.getString(sub7)+","+rs1.getString(sub7_class)+",Sub1,"+rs1.getString(sub7_ext));
         st.execute("insert into result values("+usn+","+rs1.getString(name)+","+rs1.getString(semester)+","+rs3.getString(sub8_name)+","+rs3.getString(sub8_code)+","+rs2.getString(sub8)+","+rs1.getString(sub8_class)+",Sub1,"+rs1.getString(sub8_ext));
        
        
        
        }catch(Exception e){System.out.println(e);
        }
        
        
        
        
    }*/
    
    static boolean check_student(String usn){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
       ResultSet rs = st.executeQuery("select * from Student_info where USN='"+usn+"'");
        if(rs.next()){return true;}
        }catch(Exception e){print_error("check_student");}
        return false;
    }

//IMPORTANT ! DO NOT USE OR EDIT BELOW FUNCTION GAUTAM!!! :/
    boolean login(String pass){boolean status=false;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Info", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("select * from keyring where password="+"'"+pass+"'");
        status=rs.next();
        }
        catch(Exception e){print_error("login");}
        return status;
    }
    
    void update_log(String dept, String name){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Info", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        java.util.Date dnow = new java.util.Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        st.executeUpdate("insert into log values ('"+name+"', '"+dept+"', '"+ft.format(dnow)+"');");
        }catch(Exception e){print_error("update_log");}
    }
    
    void hod(String dept){
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet detail = st.executeQuery("select name, mail  from dept_hod where dept_id='"+dept+"'");
        detail.next();
        //fifthScreen.tfProf.setText(detail.getString(dept));
        detail.next();
        //fifthScreen.tfMail.setText(detail.getString(dept));
        }catch(Exception e){print_error("hod");}
        
       
    }

    static void print_error(String location){
    JOptionPane.showMessageDialog(null, "Please check entered details or contact System Administrator. Application closing in 10 seconds.", "Error:"+location, JOptionPane.ERROR_MESSAGE);
    long start=System.currentTimeMillis();
    while(System.currentTimeMillis()<(start+1000)){}
    System.exit(0);
    }
    
}

