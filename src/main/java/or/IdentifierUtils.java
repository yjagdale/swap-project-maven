package or;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;

public class IdentifierUtils {
    public static By formIdentifier(String identifiedBy, String identificationProperty) {
        switch (identifiedBy.toUpperCase()) {
            case "ID":
                return By.id(identificationProperty);
            case "CSSSELECTOR":
                return By.cssSelector(identificationProperty);
            case "XPATH":
                return By.xpath(identificationProperty);
            default:
                return By.xpath(identificationProperty);
        }
    }
}
