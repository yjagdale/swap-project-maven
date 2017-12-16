package com.test.utilis;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.Reporter;

public class Utils {
    public static String getDateTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date).toString().replace(" ", "").replace(":", "").replace("/", "");
    }

    public static String getScreenshotPath() throws IOException, AWTException {
        Robot robot = new Robot();
        String fileName = getDateTimeStamp();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(screenFullImage, "png", new File("./target/" + fileName + ".png"));
        return new File("./target/" + fileName + ".png").getAbsolutePath();
    }

    public static File reportLogScreenshot(File file) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        String absolute = file.getAbsolutePath();
        int beginIndex = absolute.indexOf(".");
        String relative = absolute.substring(beginIndex).replace(".\\", "");
        String screenShot = relative.replace('\\', '/');


        Reporter.log("<a href=\"" + screenShot + "\"><p align=\"left\">Error screenshot at " + new Date() + "</p>");
        Reporter.log("<p><img width=\"1024\" src=\"" + file.getAbsoluteFile() + "\" alt=\"screenshot at " + new Date() + "\"/></p></a><br />");
        return file.getAbsoluteFile();
    }
}
