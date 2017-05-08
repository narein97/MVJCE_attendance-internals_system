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
 /*
 * @author narein
 */
public class Writesheet 
{
    static int dept=0,sem=0;static String dept_name,sem_string,sec;
    static String [] sub = new String[8];//To be utilised when adding subject codes
   public static void writesheet() throws Exception 
   {
      
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      XSSFSheet spreadsheet = workbook.createSheet("test_excel");
      XSSFRow row = spreadsheet.createRow((short) 0);
      XSSFCell cell = (XSSFCell) row.createCell((short) 0);
      cell.setCellValue("MVJ College of Bangalore- 560067");
      //MEARGING CELLS 
      spreadsheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 19 ));
      XSSFFont font= workbook.createFont();
      font.setFontName("Arial");
      font.setBold(true);
      XSSFCellStyle style = workbook.createCellStyle();
      style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
      style.setVerticalAlignment( XSSFCellStyle.VERTICAL_CENTER);
      style.setWrapText(true);
      style.setFont(font);
      cell.setCellStyle(style);
      Excel_operations.set_subcode();
      for(int i=0;i<8;i++){
      internal_sheet.sub[i]=sub[i];}internal_sheet.dept_name=dept_name;
      internal_sheet.sec=sec;internal_sheet.sem_string=sem_string;
      internal_sheet.internal_details(workbook);
      row = spreadsheet.createRow((short)1);
      cell = (XSSFCell) row.createCell((short)0);
      cell.setCellValue("Department of "+dept_name);
      spreadsheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 19 ));
      cell.setCellStyle(style);
      row = spreadsheet.createRow(4);
      row.setHeight((short)600);
      cell = (XSSFCell) row.createCell((short)1);
      cell.setCellValue("Semester: \n"+sem_string+sec);
      cell.setCellStyle(style);
      row = spreadsheet.createRow(5);
      String[] text = new String[3];
      text[0]="SI.No";text[1]="USN";text[2]="STUDENT\nNAME";
      for(int i=0;i<3;i++){
      cell = (XSSFCell) row.createCell((short)i);
      cell.setCellValue(text[i]);
      cell.setCellStyle(style);
      spreadsheet.addMergedRegion(new CellRangeAddress(5, 7, i, i ));
      }int j=0;
      XSSFRow row1 = spreadsheet.createRow((short) 6);
      row1.setHeight((short)1000);
      XSSFRow row2 = spreadsheet.createRow((short) 7);
      row2.setHeight((short)1000);
      for(int i=3;i<18;i++){
      cell = row1.createCell((short)i);
      cell.setCellValue("Total no. of classes");
      cell.setCellStyle(style);
      cell = row2.createCell((short)i);
      cell.setCellValue("No.of Classes attended");
      cell.setCellStyle(style);
      cell = row2.createCell((short)i+1);
      cell.setCellValue("%");
      cell.setCellStyle(style);
      cell =row.createCell((short)i);
      cell.setCellValue(sub[j]);j++;
      cell.setCellStyle(style);
      spreadsheet.addMergedRegion(new CellRangeAddress(5, 5, i, i+1 ));i++;
      }
      cell = row1.createCell((short)19);
      cell.setCellValue("%");
      cell.setCellStyle(style);
      cell =row.createCell((short)19);
      cell.setCellValue("AVG");
      cell.setCellStyle(style);
      spreadsheet.addMergedRegion(new CellRangeAddress(5, 5, 19, 19 ));
      Excel_operations.fill_exceldata(workbook,spreadsheet);
      
      FileOutputStream out = new FileOutputStream(
      new File("test_excel.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println(
      "typesofcells.xlsx written successfully");
   

   }
}