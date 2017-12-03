import org.sikuli.script.*;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class DontTap 
{
	static Screen screen = new Screen();
	
	static Rectangle gameRectangle;
	
	static double animalWidth;
	
	static double animalHeight;
	
	static int xOffset = 0;
	static int yOffset = 0;
	

	//Using the referencePhoto.png, finds the top left of grid board
	public static Location findTopLeft() throws FindFailed, IOException
	{
		BufferedImage readImage = ImageIO.read(new File("referencePhoto.png"));
		  
		System.out.println("Found top left corner at: " + screen.find(new Pattern(readImage)).getTopLeft().translate(1,  323));
		
		return screen.find(new Pattern(readImage)).getTopLeft().translate(1,  323);
		
		//return new int[] {point.getX(), point.getY()};
	}
	
	//Using bottomRight.png, finds the bottom left of grid board
	public static Location findBottomRight() throws FindFailed, IOException
	{
		BufferedImage readImage = ImageIO.read(new File("bottomright.png"));
		
		return screen.find(new Pattern(readImage)).getCenter().translate(3,  -9);
		
		//return new int[] {point.getX(), point.getY()};
	}
	
	public static int[] getAnimal(int x, int y, Robot robotScreen)
	{
		Color color1 = robotScreen.getPixelColor((int)(gameRectangle.getX() + x*animalWidth + animalWidth/2 + xOffset), (int)(gameRectangle.getY() + y*animalHeight + animalHeight/2 + yOffset));
		//System.out.println((int)(gameRectangle.getX() + x*animalWidth + animalWidth/2 + xOffset) + "  " + (int)(gameRectangle.getY() + y*animalHeight + animalHeight/2 + yOffset));
		int[] colorInt = {color1.getRed(), color1.getBlue(), color1.getGreen()};
		//int color2 = robot.getPixelColor((int)(gameRectangle.getX() + x*animalWidth + animalWidth/2 + xOffset), (int)(gameRectangle.getY() + y*animalHeight + animalHeight/2 + 10 + yOffset)).getRGB();
		//int color3 = robot.getPixelColor((int)(gameRectangle.getX() + x*animalWidth + animalWidth/2 + xOffset), (int)(gameRectangle.getY() + y*animalHeight + animalHeight/2 - 10 + yOffset)).getRGB();
		
		
		/////////////
		//robotScreen.mouseMove((int)(gameRectangle.getX() + x*animalWidth + animalWidth/2 + xOffset), (int)(gameRectangle.getY() + y*animalHeight + animalHeight/2 + yOffset));
		
		return colorInt;
	}
	
	public static int getPixelX(int x)
	{
		return (int)(gameRectangle.getX() + x*animalWidth + animalWidth/2 + xOffset);
	}
	
	public static int getPixelY(int y)
	{
		return (int)(gameRectangle.getY() + y*animalHeight + animalHeight/2 + yOffset);
	}
	
	public static void click(int x1, int y1, int x2, int y2, Robot robotScreen)
	{
		//System.out.println("I clicked!");
		robotScreen.mouseMove(getPixelX(x1), getPixelY(y1));
		robotScreen.mousePress(InputEvent.BUTTON1_MASK);
		robotScreen.mouseRelease(InputEvent.BUTTON1_MASK);
		robotScreen.mouseMove(getPixelX(x2), getPixelY(y2));
		robotScreen.mousePress(InputEvent.BUTTON1_MASK);
		robotScreen.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static void main(String[] args) throws FindFailed, IOException, AWTException 
	{
		Robot robot = new Robot();
		
		Location topLeft = new Location(491, 670);
		Location bottomRight = new Location(1400, 1600);
		
		gameRectangle = new Rectangle(topLeft.getX(), topLeft.getY(), bottomRight.getX() - topLeft.getX(), bottomRight.getY() - topLeft.getY());
		
		animalWidth = gameRectangle.getWidth()/3.0;
		
		animalHeight = gameRectangle.getHeight()/3.0;
		
		//System.out.println(gameRectangle.toString() + "  " + animalWidth + "  " + animalHeight);
		
		//found the gameboard!
		//screen.find(boardPicture.getFile()).highlight(2);
		
		gameBoard boardClass = new gameBoard(gameRectangle, robot);
		
		//System.out.println(gameRectangle.getWidth() + " " + gameRectangle.getHeight());
		
		//System.out.println("beginning board making!");
		
		boolean broke = false;
		
		
		Color squColor = robot.getPixelColor(x, y)
		
		
		
		
		/*
		for(int i = 0; i < 8; i++)
		{
			System.out.println(Arrays.toString(boardClass.getBoard()[i]));
		}
		
		//*/
		
	}
}