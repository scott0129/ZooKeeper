
import java.util.Arrays;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;

public class gameBoard 
{
	static int[][][] boardArray;
	
	static int leeway = 25;
	
	int topLeftX;
	
	int topLeftY;
	
	Robot robotScreen;
	
	
	public void clearBoard()
	{
		boardArray = new int[8][8][3];
	}
	
	public void clearBoard(int y)
	{
		if(y < 6)
		{
			if(y < 1)
			{
				y = 1;
			}
			//System.out.println("cleared half the board!");
			for(int i = y-1; i < y+1; i++)
			{
				int[][] clearArray = new int[8][3];
				boardArray[i] = clearArray;
			}
		}
		else
		{
			clearBoard();
		}
	}
	
	public gameBoard(Rectangle inputRectangle, Robot screen)
	{
		robotScreen = screen;
		topLeftX = (int)inputRectangle.getX();
		topLeftY = (int)inputRectangle.getY();
		boardArray = new int[8][8][3];
	}
	
	public void add(int x, int y, int[] animal)
	{
		boardArray[y][x] = animal;
	}
	
	public int[][][] getBoard()
	{
		return boardArray;
	}
	
    public static double Pyth3D(double x , double y, double z)
    {
        double c = Math.sqrt((z*z) + Math.pow(Math.sqrt((x*x)+(y*y)), 2));
        return c;
    }
	
	public static boolean closeEnough(int[] array1, int[] array2)
	{
		return Pyth3D(array1[0] - array2[0], array1[1] - array2[1], array1[2] - array2[2]) < leeway;
	}
	
	public static int[] getValue(int x, int y) throws AWTException
	{
		
		/*
		for(int i = 0; i < 8; i++)
		{
			System.out.println(Arrays.deepToString(boardArray[i]));
		}
		//*/
		
		//System.out.println();
		//System.out.println();
		//*/
		int[] ary = {0, 0, 0};
		if(Arrays.equals(boardArray[y][x], ary))
		{
			boardArray[y][x] = theKeeper.getAnimal(x,  y,  new Robot());
			return theKeeper.getAnimal(x, y, new Robot());
		}
		else
		{
			return boardArray[y][x];
		}
	}
	
	//check pairs
	
	public boolean check(int x, int y, int xOffset, int yOffset) throws AWTException
	{
		return closeEnough(getValue(x, y), getValue(x + xOffset, y + yOffset));
	}
	
	public boolean checkLeft(int x, int y) throws AWTException
	{
		return closeEnough(getValue(x, y), getValue(x-1, y));
	}
	
	public boolean checkRight(int x, int y) throws AWTException
	{
		return closeEnough(getValue(x, y), getValue(x+1, y));
	}
	
	public boolean checkUp(int x, int y) throws AWTException
	{
		return closeEnough(getValue(x, y), getValue(x, y-1));
	}
	
	public boolean checkDown(int x, int y) throws AWTException
	{
		return closeEnough(getValue(x, y), getValue(x, y+1));
	}
	
	//check crosses
	
	public boolean checkCrossLeft(int x, int y) throws AWTException
	{
		if(closeEnough(getValue(x, y+1), getValue(x, y-1)))
		{
			return (closeEnough(getValue(x-1, y), getValue(x, y+1)));
		}
		return false;
	}
	
	public boolean checkCrossRight(int x, int y) throws AWTException
	{
		if(closeEnough(getValue(x, y+1), getValue(x, y-1)))
		{
			return (closeEnough(getValue( x+1, y), getValue(x, y+1)));
		}
		return false;
	}

	
	public boolean checkCrossUp(int x, int y) throws AWTException
	{
		if(closeEnough(getValue(x+1, y), getValue(x-1, y)))
		{
			return (closeEnough(getValue(x, y-1), getValue(x+1, y)));
		}
		return false;
	}
	
	public boolean checkCrossDown(int x, int y) throws AWTException
	{
		if(closeEnough(getValue(x+1, y), getValue(x-1, y)))
		{
			return (closeEnough(getValue(x, y+1), getValue(x+1, y)));
		}
		return false;
	}
	
	//*/
}
