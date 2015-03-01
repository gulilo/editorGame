import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class SelectTile extends JPanel implements MouseListener
{
	private Image image;
	public SelectTile(Point loc ,BufferedImage image)
	{
		super();
		setLocation(loc);
		setSize(Map.IMAGE_SIZE,Map.IMAGE_SIZE);
		setLayout(null);
		
		this.image = image;
		
		addMouseListener(this);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null)
		{
			g.drawImage(image, 0, 0, null);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		e.consume();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		e.consume();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		e.consume();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Map.setCorrentImage(this.image);
		System.out.println("something else");
		e.consume();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		e.consume();
	}
	
	
}
