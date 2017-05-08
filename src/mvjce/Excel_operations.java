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
    public static void set_subcode(){
    switch(Writesheet.dept){
            case 0:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 1:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 2:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 3:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 4:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 5:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 6:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 7:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 8:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;
            case 9:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break; 
            case 10:Writesheet.dept_name="Aeronautical Engineering";
                        switch(Writesheet.sem){
                            case 0:
                                Writesheet.sub[0]="MAT11";
                                Writesheet.sub[1]="PHY12";
                                Writesheet.sub[2]="CIV13";
                                Writesheet.sub[3]="EME14";
                                Writesheet.sub[4]="ELE15";
                                Writesheet.sub[5]="WSL16";
                                Writesheet.sub[6]="PHYL17";
                                Writesheet.sub[7]="CIP18";
                                break;
                            case 1:
                                Writesheet.sub[0]="MAT21";
                                Writesheet.sub[1]="CHE22";
                                Writesheet.sub[2]="CCP23";
                                Writesheet.sub[3]="CED24";
                                Writesheet.sub[4]="ELN25";
                                Writesheet.sub[5]="CPL26";
                                Writesheet.sub[6]="CHEL27";
                                Writesheet.sub[7]="CIV28";
                                break;
                            case 2:
                                Writesheet.sub[0]="MAT31";
                                Writesheet.sub[1]="AE32";
                                Writesheet.sub[2]="AE33";
                                Writesheet.sub[3]="AE34";
                                Writesheet.sub[4]="AE35";
                                Writesheet.sub[5]="AE36";
                                Writesheet.sub[6]="AEL37A/37B";
                                Writesheet.sub[7]="AEL38";
                                break;
                            case 3:
                                Writesheet.sub[0]="MAT41";
                                Writesheet.sub[1]="AE42";
                                Writesheet.sub[2]="AE43";
                                Writesheet.sub[3]="AE44";
                                Writesheet.sub[4]="AE45";
                                Writesheet.sub[5]="AE46";
                                Writesheet.sub[6]="AEL47A/47B";
                                Writesheet.sub[7]="AEL48";                      
                                break;
                            case 4:
                                Writesheet.sub[0]="AL51";
                                Writesheet.sub[1]="AE52";
                                Writesheet.sub[2]="AE53";
                                Writesheet.sub[3]="SE54";
                                Writesheet.sub[4]="AE55";
                                Writesheet.sub[5]="AE56";
                                Writesheet.sub[6]="AEL57";
                                Writesheet.sub[7]="AEL58";
                                break;
                            case 5:
                                Writesheet.sub[0]="AE61";
                                Writesheet.sub[1]="AE62";
                                Writesheet.sub[2]="AE63";
                                Writesheet.sub[3]="AE64";
                                Writesheet.sub[4]="AE65";
                                Writesheet.sub[5]="Optional Subject";
                                Writesheet.sub[6]="AEL67";
                                Writesheet.sub[7]="AEL68";
                                break;
                            case 6:
                                Writesheet.sub[0]="AE71";
                                Writesheet.sub[1]="AE72";
                                Writesheet.sub[2]="AE73";
                                Writesheet.sub[3]="AE74";
                                Writesheet.sub[4]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[5]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[6]="AEL77";
                                Writesheet.sub[7]="AEL78";
                                break;
                            case 7:
                                Writesheet.sub[0]="AE81";
                                Writesheet.sub[1]="AE82";
                                Writesheet.sub[2]="OPTIONAL SUBJECT 1";
                                Writesheet.sub[3]="OPTIONAL SUBJECT 2";
                                Writesheet.sub[4]="";
                                Writesheet.sub[5]="";
                                Writesheet.sub[6]="";
                                Writesheet.sub[7]="";        
                                break;
                        }
                        break;            
                }
        }
    
    public static void fill_exceldata(XSSFWorkbook workbook,XSSFSheet spreadsheet){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet detail = st.executeQuery("select attendance.USN,Student_info.Name,attendance.sub1_class,attendance.sub2_class,"
                + "                         attendance.sub3_class,attendance.sub4_class,attendance.sub5_class,attendance.sub6_class,attendance.sub7_class,attendance.sub8_class from attendance inner join "
                + "                         Student_info on attendance.USN = Student_info.USN;");
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
"where s.Class='B';");
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

