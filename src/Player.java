import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Player extends Character implements KeyListener
{

	public Player(Point loc, Dimension size)
	{
		super(loc, size);
		try
		{

			File file = new File("Images\\player.png");
			image = ImageIO.read(file);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			image = null;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			move("right");
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			move("left");
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}
}
