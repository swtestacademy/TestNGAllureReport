package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Credential: Shantonu Sarker on 9/11/16. (Thanks to him.)
 */

public class ScreenShotRobot {

    public void saveAsImage(byte[] imageAsByteArray, String name) {
        InputStream in = new ByteArrayInputStream(imageAsByteArray);
        BufferedImage bImageFromConvert = null;
        File file;
        try {
            file = new File("./Images/"+name);
            bImageFromConvert = ImageIO.read(new ByteArrayInputStream(imageAsByteArray));
            ImageIO.write(bImageFromConvert, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void capture(String filePath) {
        try {
            BufferedImage screencapture = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File file = new File(filePath);
            ImageIO.write(screencapture, "jpg", file);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void capturePNG(String filePath) {
        try {
            BufferedImage screencapture = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File file = new File(filePath);
            ImageIO.write(screencapture, "png", file);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] capturePNG() {
        byte[] out = null;
        try {
            BufferedImage screencapture = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ImageIO.write(screencapture, "png", bo);
            out = bo.toByteArray();
            bo.close();

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static byte[] capture() {
        byte[] out = null;
        try {
            BufferedImage screencapture = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ImageIO.write(screencapture, "jpg", bo);
            out = bo.toByteArray();
            bo.close();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}