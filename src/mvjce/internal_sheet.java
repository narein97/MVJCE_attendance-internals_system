/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvjce;


import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author narein
 */
public class internal_sheet{
    static String dept_name,sem_string,sec="A";
    static String [] sub = new String[8];
   public static void internal_details(XSSFWorkbook workbook){ 
      XSSFSheet spreadsheet = workbook.createSheet("test_excel_internal");
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
      row = spreadsheet.createRow((short)1);
      cell = (XSSFCell) row.createCell((short)0);
      cell.setCellValue("Department of "+dept_name);
      spreadsheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 19 ));
      cell.setCellStyle(style);
      row = spreadsheet.createRow(3);
      row.setHeight((short)600);
      cell = (XSSFCell) row.createCell((short)1);
      cell.setCellValue("Semester: \n"+sem_string+sec);
      cell.setCellStyle(style);
      row = spreadsheet.createRow(4);
      String[] text = new String[3];
      text[0]="SI.No";text[1]="USN";text[2]="STUDENT NAME";
      for(int i=0;i<3;i++){
      cell = (XSSFCell) row.createCell((short)i);
      cell.setCellValue(text[i]);
      cell.setCellStyle(style);
      spreadsheet.addMergedRegion(new CellRangeAddress(4, 5, i, i ));
      }
      XSSFRow row2 = spreadsheet.createRow((short)5 );
      for(int i=0,j=3;j<=23;j+=4){
      cell =row.createCell((short)j);
      cell.setCellValue(sub[i]);i++;
      cell.setCellStyle(style);
      cell =row2.createCell(j);cell.setCellValue("T1");cell.setCellStyle(style);
      cell =row2.createCell(j+1);cell.setCellValue("T2");cell.setCellStyle(style);
      cell =row2.createCell(j+2);cell.setCellValue("T3");cell.setCellStyle(style);
      cell =row2.createCell(j+3);cell.setCellValue("Avg");cell.setCellStyle(style);
      spreadsheet.addMergedRegion(new CellRangeAddress(4, 4, j,j+3 ));
      Excel_operations.insert_internals(workbook, spreadsheet);
      }
   }
}
