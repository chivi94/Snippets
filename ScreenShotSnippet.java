import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ScreenShotSnippet {

	/**
	 * Method to get the system date and hour
	 * 
	 * @return System date and hour in format "dd/MM/yyyy HH:mm:ss"
	 */
	public static String getCurrentDateOne() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd-MM-yyyy.HH-mm-ss");
		Date date = new Date();
		return simpleDateFormat.format(date);
	}
	
	/**
	 * Method that takes a screenshot of our PC
	 * @param fileName The name of the screenshot
	 * @throws Exception If something went wrong
	 */
	public static void captureScreen(String fileName) throws Exception {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		Robot robot = new Robot();
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		ImageIO.write(bufferedImage, "png", new File(fileName));

	}

	public static void main(String args[]) {
		try {
			//I create the image file with the system date. See the "SystemDataSnippet"
			captureScreen(getCurrentDateOne()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
