import javax.swing.*;
import java.awt.*;

public abstract class Character extends JPanel
{
	protected Image image;

	public Character(Point loc,Dimension size)
	{
		super();
		setLocation(loc);
		setSize(size);
	}

	public void move(String direction)
	{

	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(image != null)
		{
			g.drawImage(image,0,0,null);
		}
		else
		{
			g.setColor(Color.BLUE);
			g.fillRect(0,0,getSize().width,getSize().height);
		}
	}
}
