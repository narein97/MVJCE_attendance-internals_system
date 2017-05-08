/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvjce;
import java.io.File;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Chunk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.time.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author narein
 */
public class PDF {

    /**
     * @param args the command line arguments
     */
    static String cl,sem,name,usn,internal;
    static String sub[] = new String[8];
    static String subcode[] = new String[8];
    static String intr[] = new String[8];static String att[] = new String[8];
    
    public static void pdf(){
        try{System.out.println(internal);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //Statement st4 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet info = st.executeQuery("select Name,USN from Student_info where class='"+cl+"' and semester ='"+sem+"'");
        //name=info.getString("Name");usn=info.getString("USN");
        ResultSet info1;// =st1.executeQuery("select c.sub1_name,c.sub2_name,c.sub3_name,c.sub4_name,c.sub5_name,c.sub6_name,c.sub7_name,c.sub8_name\n" +
//"from Subject_names as c join Student_info as s on c.Course_code=s.Course_code where s.USN='1MJ10AE002'");
// =st2.executeQuery("select c.sub1_code,c.sub2_code,c.sub3_code,c.sub4_code,c.sub5_code,c.sub6_code,c.sub7_code,c.sub8_code\n" +
//"from Scheme as c join Student_info as s on c.Course_code=s.Course_code where s.USN='1MJ10AE002'");
//=st3.executeQuery("select s1.sub1_int1,s1.sub2_int1,s1.sub3_int1,s1.sub4_int1,s2.sub5_int1,s2.sub6_int1,s2.sub7_int1,s2.sub8_int1\n" +
//"from internals as s1 join internals2 as s2 on s1.USN=s2.USN where s1.USN='1MJ10AE002';");
// = st4.executeQuery("select sub1_class,sub2_class,sub3_class,sub4_class,sub5_class,sub6_class,sub7_class,sub8_class\n" +
//"from attendance where USN='1MJ10AE002';");
        File fl = new File("/home/narein/NetBeansProjects/"+sem+cl);
        fl.mkdir();
        int j=1;
        while(info.next()){name=info.getString("Name");usn=info.getString("USN");
            info1=st1.executeQuery("select c.sub1_name,c.sub2_name,c.sub3_name,c.sub4_name,c.sub5_name,c.sub6_name,c.sub7_name,c.sub8_name " +
"from Subject_names as c join Student_info as s on c.Course_code=s.Course_code where s.USN='"+usn+"'");
            info1.next();for(int i=0;i<8;i++){sub[i]=info1.getString(i+1);}
            info1=st1.executeQuery("select c.sub1_code,c.sub2_code,c.sub3_code,c.sub4_code,c.sub5_code,c.sub6_code,c.sub7_code,c.sub8_code " +
"from Scheme as c join Student_info as s on c.Course_code=s.Course_code where s.USN='"+usn+"'");
            info1.next();for(int i=0;i<8;i++){subcode[i]=info1.getString(i+1);}
            info1=st1.executeQuery("select s1.sub1_int"+internal+",s1.sub2_int"+internal+",s1.sub3_int"+internal+",s1.sub4_int"+internal+",s2.sub5_int"+internal+",s2.sub6_int"+internal+",s2.sub7_int"+internal+",s2.sub8_int"+internal+
" from internals as s1 join internals2 as s2 on s1.USN=s2.USN where s1.USN='"+usn+"'");
            info1.next();System.out.println(info1.getString(1));
            for(int i=0;i<8;i++){intr[i]=info1.getString(i+1);}
            info1=st1.executeQuery("select sub1_class,sub2_class,sub3_class,sub4_class,sub5_class,sub6_class,sub7_class,sub8_class " +
"from attendance where USN='"+usn+"'");
            info1.next();for(int i=0;i<8;i++){att[i]=info1.getString(i+1);}
            create(j);j++;
        }
        }catch(Exception e){System.out.println(e);}
    }
    
    public static void create(int sino) {// sino = SI.No
        // TODO code application logic here
        try {
       	//Create Document instance.
	Document document = new Document();
 
	//Create OutputStream instance.
	OutputStream outputStream = 
		new FileOutputStream(new File("/home/narein/NetBeansProjects/"+sem+cl+"/"+usn+".pdf"));
 
	//Create PDFWriter instance.
        PdfWriter.getInstance(document, outputStream);
 
        //Open the document.
        document.open();
        //image position
        Image imageCenter = Image.getInstance("/home/narein/Downloads/mvj.png");
        //imageCenter.setAlignment(Image.MIDDLE);
        imageCenter.setAbsolutePosition(235, 780);
        imageCenter.scaleAbsolute(146f, 53f);
        //Permanently affiliated para
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.addCell(getCell("\n\n\nPermanently affiliated to VTU, Govt. of Karnataka\nApproved by AICTE, New Delhi\nNear ITPB, Bengaluru- 560067\n\nProf. Mahesh Prabhu, HOD - AE", PdfPCell.ALIGN_LEFT));
        table.addCell(getCell("\n\n\n\nPh: 080-42991000\nFax: 080-28452443\nWebsite: www.mvjce.edu.in\nEmail: hod_aero@mvjce.edu.in\n\n", PdfPCell.ALIGN_RIGHT));
        //line across pdf
        final LineSeparator lineSeparator = new LineSeparator();
        Chunk linebreak = new Chunk(lineSeparator);
        Phrase p = new Phrase("\nPROGRESS REPORT\n",new Font(FontFamily.TIMES_ROMAN, 10,Font.UNDERLINE|Font.BOLD));
        Paragraph para = new Paragraph(p);para.setAlignment(Element.ALIGN_CENTER);
        Chunk glue = new Chunk(new VerticalPositionMark());
        Paragraph p1 = new Paragraph("\nRef:",new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD));
        p1.add(new Chunk(glue));
        //get current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.now();
        //add date to pdf
        p1.add(new Phrase("Date: "+dtf.format(localDate)+"\n",new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD)));
        Phrase dear_prnts = new Phrase("Dear Parents,\n",new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD));
        Phrase The_acad = new Phrase("                  The academic performance of your ward Mr/Ms "+name+" of Semester "+sem+" bearing the USN "+usn+" is as follows,\n\n",new Font(FontFamily.TIMES_ROMAN, 9));
        Phrase Rem = new Phrase("Remarks\n",new Font(FontFamily.TIMES_ROMAN, 10,Font.UNDERLINE|Font.BOLD));
        Phrase your_ward = new Phrase("\nYour ward's overall performance is Good / Satisfactory / Poor / Very Poor\n",new Font(FontFamily.TIMES_ROMAN, 9));
        Phrase you_are = new Phrase("\nYou are requested to:\n",new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD));
        Phrase req = new Phrase("");
        Paragraph para2 = new Paragraph("1) Advice your ward to attend classes regularly\n2) Note that he/she may likely be detainedfrom appearing for examinations\n"
                + "3) Advice your ward to improve in Test/Exam performance particularly in subject\n4) Meet the Head of the Department\n5) Meet the principal\n",new Font(FontFamily.TIMES_ROMAN, 9));
        Chunk glue1 = new Chunk(new VerticalPositionMark());
        Paragraph p3 = new Paragraph("\nSIGNATURE:\n\nNAME OF PROCTOR:\n\nCONTACT NUMBER:",new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD));
        p3.add(new Chunk(glue1));
        p3.add(new Phrase("SIGNATURE OF HOD\n\n            Kindly attend the Parent Teacher Meeting to be held on the \n",new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD)));
        Phrase Note = new Phrase("\nNOTE:",new Font(FontFamily.TIMES_ROMAN, 10,Font.UNDERLINE|Font.BOLD));
        Paragraph p4 = new Paragraph();p4.add(Note);p4.add(new Phrase("  Parents are requested to contact the proctor (By Email/Letter/Phone) and confirm receipt of this feedback. Parents are also"
                + "welcome to interact with proctors/subject faculty/ HOD for any discussion/clarification.\n",new Font(FontFamily.TIMES_ROMAN, 9)));
        //Add content to the document.
        document.add(imageCenter);
        document.add(table);
        document.add(linebreak);
        document.add(para);document.add(p1);document.add(dear_prnts);document.add(The_acad);
        document.add(createinternalsTable());
        if(internal.equals("1")){
            document.add(new Phrase("\nPREVIOUS SEMESTER VTU RESULT\n\n",new Font(FontFamily.TIMES_ROMAN, 10,Font.UNDERLINE|Font.BOLD)));
            document.add(createexternalTable());
        }
        document.add(Rem);
        document.add(your_ward);document.add(you_are);
        document.add(para2);document.add(p3);document.add(p4);
        //document.add(paragraph);document.add(paragraph1);
 
        //Close document and outputStream.
        document.close();
        outputStream.close();
 
        System.out.println("Pdf created successfully.");
    } catch (Exception e) {
	e.printStackTrace();
    }
        
    }
    
    public static PdfPCell getCell(String text, int alignment) {
    
    PdfPCell cell = new PdfPCell(new Phrase(text,new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD)));
    cell.setPadding(1);
    cell.setHorizontalAlignment(alignment);
    cell.setBorder(PdfPCell.NO_BORDER);
    return cell;
}
    
public static PdfPTable createinternalsTable() {
    	// a table with five columns
        //try{
        /*Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_data", "root", "root");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement st4 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet info = st.executeQuery("select Name,USN from Student_info where class='"+cl+"' and semeter ='"+sem+"'");
        ResultSet info1 =st1.executeQuery("select c.sub1_name,c.sub2_name,c.sub3_name,c.sub4_name,c.sub5_name,c.sub6_name,c.sub7_name,c.sub8_name\n" +
"from Subject_names as c join Student_info as s on c.Course_code=s.Course_code where s.USN='1MJ10AE002'");
        ResultSet info2 =st2.executeQuery("select c.sub1_code,c.sub2_code,c.sub3_code,c.sub4_code,c.sub5_code,c.sub6_code,c.sub7_code,c.sub8_code\n" +
"from Scheme as c join Student_info as s on c.Course_code=s.Course_code where s.USN='1MJ10AE002'");
        ResultSet info3 =st3.executeQuery("select s1.sub1_int1,s1.sub2_int1,s1.sub3_int1,s1.sub4_int1,s2.sub5_int1,s2.sub6_int1,s2.sub7_int1,s2.sub8_int1\n" +
"from internals as s1 join internals2 as s2 on s1.USN=s2.USN where s1.USN='1MJ10AE002';");
        ResultSet info4 = st4.executeQuery("select sub1_class,sub2_class,sub3_class,sub4_class,sub5_class,sub6_class,sub7_class,sub8_class\n" +
"from attendance where USN='1MJ10AE002';");*/
        
        PdfPTable table = new PdfPTable(5);
        float f[] = new float[]{0.5f,3f,1f,1f,1.5f};
        try{table.setWidths(f);}catch(Exception e){System.out.println(e);}
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("SI.No",new Font(FontFamily.TIMES_ROMAN, 9,Font.BOLD)));
        cell.setRowspan(3);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("SUBJECT TITLE",new Font(FontFamily.TIMES_ROMAN, 9,Font.BOLD)));
        cell.setRowspan(3);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("SUB CODE",new Font(FontFamily.TIMES_ROMAN, 9,Font.BOLD)));
        cell.setRowspan(3);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Internal"+internal+" Test Marks",new Font(FontFamily.TIMES_ROMAN, 9,Font.BOLD)));
        cell.setRowspan(3);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Attendance\nAS ON DATE",new Font(FontFamily.TIMES_ROMAN, 9,Font.BOLD)));
        cell.setRowspan(3);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        
        for(int i=1;i<=8;i++){
        table.addCell(new Phrase(Integer.toString(i),new Font(FontFamily.TIMES_ROMAN, 9)));
        table.addCell(new Phrase(sub[i-1],new Font(FontFamily.TIMES_ROMAN, 9)));
        table.addCell(new Phrase(subcode[i-1],new Font(FontFamily.TIMES_ROMAN, 9)));
        table.addCell(new Phrase(intr[i-1],new Font(FontFamily.TIMES_ROMAN, 9)));
        table.addCell(new Phrase(att[i-1],new Font(FontFamily.TIMES_ROMAN, 9)));
        }return table;
        //}catch(Exception e){System.out.println(e);}return null;
    }

    public static PdfPTable createexternalTable(){
        PdfPTable table = new PdfPTable(10);
        PdfPCell cell;
        for(int i=1;i<=10;i++){
        cell = new PdfPCell(new Phrase("sub"+Integer.toString(i),new Font(FontFamily.TIMES_ROMAN, 9)));
        cell.setRowspan(2);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        }
        for(int i=1;i<=10;i++){
        cell = new PdfPCell(new Phrase("value"+Integer.toString(i),new Font(FontFamily.TIMES_ROMAN, 9)));
        cell.setRowspan(2);cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        }
        return table;
    }
    
    
}
