package readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public String[][] getData(String sheetName) throws IOException {
        String a = URLDecoder.decode(this.getClass().getClassLoader().getResource("data.xlsx").getPath(), "UTF-8");
        FileInputStream file = new FileInputStream(new File(a));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rows = sheet.getPhysicalNumberOfRows();//Get number of rows
        int cols = sheet.getRow(1).getPhysicalNumberOfCells();//Total number of columns/headers
        String[][] srtArray = new String[rows - 1][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                srtArray[i - 1][j] = cell.getStringCellValue();
            }
        }
        file.close();
        return srtArray;
    }

    public XSSFSheet getOrData() {
        String a = null;
        String orFileName = System.getProperty("Orfile") != null ? System.getProperty("Orfile") : "data.xlsx";
        try {
            System.out.println("Using "+orFileName+ " as OBJECT REPOSITORY");
            a = URLDecoder.decode(this.getClass().getClassLoader().getResource(orFileName).getPath(), "UTF-8");
            XSSFWorkbook workbook = new XSSFWorkbook(a);
            XSSFSheet sheet = workbook.getSheetAt(0);
            return sheet;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
