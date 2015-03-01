import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class EditorTile extends JPanel implements MouseListener
{
	private Image image;

	public EditorTile(Point loc, Image image)
	{
		super();
		setSize(Map.IMAGE_SIZE,Map.IMAGE_SIZE);
		setLocation(loc);
		setLayout(null);

		this.image = image;
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(image != null)
		{
			g.drawImage(image, 0, 0, null);
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		image = Map.getCorrentImage();
		System.out.println("somthing");
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
