package or;

import readers.ExcelReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;

import java.util.HashMap;

public class ObjectRepository {

    public static HashMap<String, By> objectRepository = new HashMap<>();

    public static void addORObject(String elementName, By identifier) {
        objectRepository.put(elementName, identifier);
    }

    public static By getORObject(String key) {
        return objectRepository.get(key);
    }

    public static void loadRepository(){
        ExcelReader excelReader = new ExcelReader();
        XSSFSheet sheet = excelReader.getOrData();
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rows; i++) {
            XSSFRow column = sheet.getRow(i);
            String elementName = column.getCell(0).getStringCellValue();
            String identifiedBy = column.getCell(1).getStringCellValue();
            String identificationProperty = column.getCell(2).getStringCellValue();

            By identifier = IdentifierUtils.formIdentifier(identifiedBy, identificationProperty);
            addORObject(elementName, identifier);
        }
        excelReader = null;
    }
}
