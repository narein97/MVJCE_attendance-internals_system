/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvjce;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;
import java.util.*;
import java.text.*;
/**
 *
 * @author narein
 */
public class Excel_operations {
    public static void set_subcode(){String scheme="not";
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet detail = st.executeQuery("select Course_code from Student_info where Class='"+Writesheet.sec+"' and semester="+Writesheet.sem_string);
        detail.next();scheme=detail.getString("Course_code");
        detail = st.executeQuery("select * from Scheme where Course_code='"+scheme+"'");
        detail.next();
        Writesheet.sub[0]=detail.getString(2);
        Writesheet.sub[1]=detail.getString(3);
        Writesheet.sub[2]=detail.getString(4);
        Writesheet.sub[3]=detail.getString(5);
        Writesheet.sub[4]=detail.getString(6);
        Writesheet.sub[5]=detail.getString(7);
        Writesheet.sub[6]=detail.getString(8);
        Writesheet.sub[7]=detail.getString(9);
        }catch(Exception e){
            //Database.print_error("Excel_scheme");
            System.out.println("select Course_code from Student_info where Class='"+Writesheet.sec+"' and semester="+Writesheet.sem_string);System.out.println(e);}
        }
    
    public static void fill_exceldata(XSSFWorkbook workbook,XSSFSheet spreadsheet){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet detail = st.executeQuery("select attendance.USN,Student_info.Name,attendance.sub1_class,attendance.sub2_class,"
                + " attendance.sub3_class,attendance.sub4_class,attendance.sub5_class,attendance.sub6_class,attendance.sub7_class,attendance.sub8_class from attendance inner join "
                + " Student_info on attendance.USN = Student_info.USN where class='"+Writesheet.sec+"' and semester="+Writesheet.sem_string+" ;");
        int i=1,j=8;
        
        XSSFFont font= workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setVerticalAlignment( XSSFCellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setFont(font);
        XSSFCell cell;
        while(detail.next()){
        XSSFRow row = spreadsheet.createRow((short) j);
        row.setHeight((short)900);
        cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue(i);i++;
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue(detail.getString(1));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue(detail.getString(2));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 3);
        cell.setCellValue(detail.getString(3));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 5);
        cell.setCellValue(detail.getString(4));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 7);
        cell.setCellValue(detail.getString(5));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 9);
        cell.setCellValue(detail.getString(6));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 11);
        cell.setCellValue(detail.getString(7));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 13);
        cell.setCellValue(detail.getString(8));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 15);
        cell.setCellValue(detail.getString(9));
        cell.setCellStyle(style);
        cell = (XSSFCell) row.createCell((short) 17);
        cell.setCellValue(detail.getString(10));
        cell.setCellStyle(style);j++;
        }
        
        }catch(Exception e){System.out.println(e);}
    }
    
    public static void insert_internals(XSSFWorkbook workbook,XSSFSheet spreadsheet){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet detail = st.executeQuery("select s.USN,s.Name,i.sub1_int1,i.sub1_int2,i.sub1_int3,i.sub2_int1,i.sub2_int2,i.sub2_int3,i.sub3_int1,i.sub3_int2,i.sub3_int3,i.sub4_int1,i.sub4_int2,i.sub4_int3,\n" +
"i2.sub5_int1,i2.sub5_int2,i2.sub5_int3,i2.sub6_int1,i2.sub6_int2,i2.sub6_int3,i2.sub7_int1,i2.sub7_int2,i2.sub7_int3,i2.sub8_int1,i2.sub8_int2,i2.sub8_int3\n" +
"from internals as i\n" +
"join Student_info as s\n" +
"on i.USN=s.USN\n" +
"join internals2 as i2\n" +
"on i2.USN=s.USN\n" +
"where s.Class='"+Writesheet.sec+"' and s.semester="+Writesheet.sem_string+";");
        int i=1,j=6;
        XSSFFont font= workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setVerticalAlignment( XSSFCellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setFont(font);
        XSSFCell cell;
        while(detail.next()){
        XSSFRow row = spreadsheet.createRow((short) j);
        cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue(i);
        cell.setCellStyle(style);
        for(int k=1;k<=26;k++){
        cell = (XSSFCell) row.createCell((short) k);
        cell.setCellValue(detail.getString(k));
        cell.setCellStyle(style);
        }
        i++;j++;
        }
        spreadsheet.autoSizeColumn(2);
        spreadsheet.autoSizeColumn(1);
        }catch(Exception e){System.out.println(e);}
    }
}

