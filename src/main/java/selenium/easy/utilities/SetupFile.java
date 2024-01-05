package main.java.selenium.easy.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.Properties;

public class SetupFile {

    // Create new file
    public static void createFile(String fileName){
        try{
            XSSFWorkbook workbook= new XSSFWorkbook();
            FileOutputStream fos=new FileOutputStream(fileName);
            workbook.write(fos);
            fos.flush();
            fos.close();
            workbook.close();
        }catch(Exception e){
           e.printStackTrace();
        }
    }

    // Create 1 sheet
    public static void createSheet(String fileName, String sheetName){
        try{
            FileInputStream fis=new FileInputStream(new File(fileName));
            XSSFWorkbook workbook= new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheet(sheetName);
            if(sheet==null) {
                sheet = workbook.createSheet(sheetName);
            }
            fis.close();
            FileOutputStream fos=new FileOutputStream(fileName);
            workbook.write(fos);
            fos.flush();
            fos.close();
            workbook.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Write 1 cell
    public static void writeCell(String fileName, String sheetName, int idRow, int idCell, String content){
        try{
            FileInputStream fis=new FileInputStream(fileName);
            XSSFWorkbook workbook= new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheet(sheetName);
            XSSFRow row=sheet.getRow(idRow);
            if(row == null){
                row=sheet.createRow(idRow);
            }
            XSSFCell cell=row.getCell(idCell);
            if(cell == null){
                cell=row.createCell(idCell, CellType.STRING);
            }
            cell.setCellValue(content);
            setCellStyle(workbook, cell);
            fis.close();
            FileOutputStream fos=new FileOutputStream(fileName);
            workbook.write(fos);
            fos.flush();
            fos.close();
            workbook.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  static String readCell(String fileName, String sheetName, int idRow, int idCell){
        String result="";
        try{
            FileInputStream fis=new FileInputStream(fileName);
            XSSFWorkbook workbook= new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheet(sheetName);
            XSSFRow row=sheet.getRow(idRow);
            if(row == null){
                row=sheet.createRow(idRow);
            }
            XSSFCell cell=row.getCell(idCell);
            if(cell == null){
                cell=row.createCell(idCell, CellType.STRING);
            }
            result = cell.getStringCellValue();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static void setCellStyle(XSSFWorkbook workbook, XSSFCell cell){
       Font font = workbook.createFont();
       font.setFontName("Times New Roman");
       font.setBold(true);
       font.setItalic(true);
       font.setColor(Font.COLOR_RED);
       // set font height = 20 * {font size}
       // font.setFontHeight((short) 240);
       font.setFontHeightInPoints((short) 14);
       CellStyle style = workbook.createCellStyle();
       style.setFont(font);
       style.setBorderTop(BorderStyle.THIN);
       style.setBorderBottom(BorderStyle.THIN);
       style.setBorderLeft(BorderStyle.THIN);
       style.setBorderRight(BorderStyle.THIN);
       cell.setCellStyle(style);
    }

    public static String readProperiesFile(String path, String key) {
        String rs="";
        try{
            Properties properties=new Properties();
            FileInputStream fis=new FileInputStream(path);
            properties.load(fis);
            rs = properties.getProperty(key);
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;

    }

    public static void writeProperiesFile(String path, String key, String value) {
        try{
            Properties properties=new Properties();
            FileInputStream fis=new FileInputStream(path);
            properties.load(fis);
            properties.setProperty(key, value);
            fis.close();
            FileOutputStream fos=new FileOutputStream(path);
            properties.store(fos, "Write");
            fos.flush();
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
       String fileName= "src/main/resources/" + "account.properties";
//       createFile(fileName);
//       createSheet(fileName, "Student");
//       writeCell(fileName, "Student", 0,1, "Tran Thi Hue");
//       System.out.println(readCell(fileName, "Student", 0,0));
        System.out.println(readProperiesFile(fileName, "username"));
        writeProperiesFile(fileName, "PIN", "1234");
    }

}
