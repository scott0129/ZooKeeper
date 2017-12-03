import org.sikuli.basics.Debug;
import org.sikuli.script.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShotter 
{
	public static void main(String[] args) throws FindFailed, IOException 
	{
		Debug.setDebugLevel(3);
		  
		Screen screen = new Screen();
		  
		Region r = screen.selectRegion();
		  
		BufferedImage bi = screen.capture(r).getImage();
		  
		ImageIO.write(bi, "png", new File("Filler.png"));
	}
}
